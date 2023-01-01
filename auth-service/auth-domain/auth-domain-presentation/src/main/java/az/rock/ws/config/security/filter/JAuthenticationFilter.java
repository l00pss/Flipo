package az.rock.ws.config.security.filter;


import az.rock.lib.jexception.JRuntimeException;
import az.rock.lib.message.MessageProvider;
import az.rock.lib.util.JHttpConstant;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.config.security.UserAuthDetailsService;
import az.rock.ws.dto.request.AuthLogCommand;
import az.rock.ws.dto.request.AuthUserCommand;
import az.rock.ws.exception.UserNotFoundJException;
import az.rock.ws.port.input.service.abstracts.AuthLogService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class JAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final UserAuthDetailsService userAuthDetailsService;
    private final MessageProvider messageProvider;
    private final AuthLogService authLogService;


    public JAuthenticationFilter(UserAuthDetailsService authService, AuthenticationManager authenticationManager, MessageProvider messageProvider,AuthLogService authLogService) {
        super.setAuthenticationManager(authenticationManager);
        this.userAuthDetailsService = authService;
        this.messageProvider = messageProvider;
        this.authLogService = authLogService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String lang = Objects.requireNonNullElse(request.getHeader(JHttpConstant.LANG), "en");
        String privateKey = Objects.requireNonNull(request.getHeader(JHttpConstant.USER_PRIVATE_KEY),()->this.messageProvider.fail( "F_0000000001","en"));
        try {
            var stream = request.getInputStream();
            AuthUserCommand authUserCommand = new ObjectMapper().readValue(new String(stream.readAllBytes(), StandardCharsets.UTF_8), AuthUserCommand.class);
            UserDetails userDetails = this.userAuthDetailsService.loadUserByUsername(authUserCommand.username());

            var authManager = getAuthenticationManager();
            var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken( authUserCommand.username(), null,userDetails.getAuthorities());

            this.userAuthDetailsService.matches(userDetails,authUserCommand.password());
            //super.setDetails(request,usernamePasswordAuthenticationToken);
            return authManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (IOException e) {
            throw new UserNotFoundJException(this.messageProvider.fail( "F_0000000001",lang));
        }
    }


    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)  {
        String privateKey = Objects.requireNonNull(request.getHeader(JHttpConstant.USER_PRIVATE_KEY),()->this.messageProvider.fail( "F_0000000001","en"));

        UserRoot userRoot = this.userAuthDetailsService.getUserRoot(((UserDetails) authResult.getDetails()).getUsername());
        String lang = Objects.requireNonNullElse(request.getHeader(JHttpConstant.LANG), "en");

        var claimObject = ClaimObject.builder(userRoot)
                .withPrivateKey(privateKey)
                .withIpAddress("ipAddress")
                .build();

        Map<String, Object> claims = this.generateClaim(claimObject);

        String token = this.generateToken(claims, privateKey);

        response.addHeader(JHttpConstant.TOKEN, token);

        var command = AuthLogCommand
                .builder()
                .userUUID(userRoot.getIdValue())
                .username(userRoot.getUsername())
                .userPrivateKey(privateKey)
                .ipAddress("ipAddress")
                .build();

        if(!this.authLogService.logAuthenticate(command))
            throw new JRuntimeException(this.messageProvider.fail( "F_0000000003",lang));

        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(authResult);
    }

    private String generateToken(Map<String, Object> claims, String privateKey) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(this.userAuthDetailsService.getTokenExpDate())))
                .signWith(SignatureAlgorithm.HS512, this.userAuthDetailsService.getSecurityKey().concat(privateKey))
                .setClaims(claims)
                .compact();
    }


    private Map<String, Object> generateClaim(ClaimObject<UserRoot> claimObject) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JHttpConstant.USER_PRIVATE_KEY, claimObject.getPrivateKey());
        claims.put(JHttpConstant.UUID, claimObject.getRoot().getIdValue());
        claims.put(JHttpConstant.ROLE, claimObject.getRoot().getRole());
        claims.put(JHttpConstant.IP_ADDRESS, claimObject.getIpAddress());
        return claims;
    }


}

class ClaimObject<T> {

    private T root;

    private String privateKey;

    private String ipAddress;

    public String getPrivateKey() {
        return privateKey;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public T getRoot() {
        return root;
    }

    private ClaimObject(Builder<T> builder) {
        root = builder.root;
        privateKey = builder.privateKey;
        ipAddress = builder.ipAddress;
    }

    public static <T> Builder<T> builder(T data) {
        return new Builder<T>(data);
    }

    public static final class Builder<T> {
        private final T root;
        private String privateKey;
        private String ipAddress;

        private Builder(T data) {
            this.root = data;
        }


        public Builder<T> withPrivateKey(String privateKey) {
            this.privateKey = privateKey;
            return this;
        }


        public Builder<T> withIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public ClaimObject<T> build() {
            return new ClaimObject<T>(this);
        }
    }
}