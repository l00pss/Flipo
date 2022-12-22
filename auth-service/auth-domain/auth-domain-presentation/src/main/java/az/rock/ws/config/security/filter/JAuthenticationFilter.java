package az.rock.ws.config.security.filter;


import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.message.MessageProvider;
import az.rock.lib.util.JHttpConstant;
import az.rock.lib.value.generic.JLanguage;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.config.security.UserAuthDetailsService;
import az.rock.ws.dto.request.AuthUserCommand;
import az.rock.ws.exception.UserNotFoundJException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.http.HttpStatus;
import org.bouncycastle.util.encoders.Base64Encoder;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/*
 Header
    LANG
 Body
     username
     password
     privateKey
 */
public class JAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final UserAuthDetailsService userAuthDetailsService;
    private final MessageProvider messageProvider;


    public JAuthenticationFilter(UserAuthDetailsService authService, AuthenticationManager authenticationManager, MessageProvider messageProvider) {
        super.setAuthenticationManager(authenticationManager);
        this.userAuthDetailsService = authService;
        this.messageProvider = messageProvider;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String lang = Objects.requireNonNullElse(request.getHeader(JHttpConstant.LANG), "en");
        try {
            AuthUserCommand authUserCommand = new ObjectMapper().readValue(request.getInputStream(), AuthUserCommand.class);
            return getAuthenticationManager().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authUserCommand.username(),
                            authUserCommand.password(),
                            new ArrayList<>()));
        } catch (IOException e) {
            throw new UserNotFoundJException(this.messageProvider.fail( "F_0000000001",lang));
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {
        AuthUserCommand authUserCommand = new ObjectMapper().readValue(request.getInputStream(), AuthUserCommand.class);
        String privateKey = Objects.requireNonNull(request.getHeader(JHttpConstant.USER_PRIVATE_KEY),()->this.messageProvider.fail( "F_0000000001","en"));
        UserRoot userRoot = this.userAuthDetailsService.matches(authResult);
        Map<String, Object> claims = this.generateClaim(userRoot,privateKey);
        String token = this.generateToken(claims, authUserCommand.privateKey());
        response.addHeader(JHttpConstant.TOKEN, token);
    }

    private String generateToken(Map<String, Object> claims, String privateKey) {
        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(this.userAuthDetailsService.getTokenExpDate())))
                .signWith(SignatureAlgorithm.HS512, this.userAuthDetailsService.getSecurityKey().concat(privateKey))
                .setClaims(claims)
                .compact();
    }


    private Map<String, Object> generateClaim(UserRoot userRoot,String privateKey) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(JHttpConstant.USER_PRIVATE_KEY, privateKey);
        claims.put(JHttpConstant.UUID, userRoot.getIdValue());
        claims.put(JHttpConstant.ROLE, userRoot.getRole());
        return claims;
    }

}
