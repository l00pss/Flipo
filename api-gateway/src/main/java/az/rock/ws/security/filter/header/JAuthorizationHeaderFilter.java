package az.rock.ws.security.filter.header;

import az.rock.lib.jexception.JRuntimeException;
import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.kafka.event.UserRequestEvent;
import az.rock.lib.kafka.model.UserRequestModel;
import az.rock.lib.message.MessageProvider;
import az.rock.lib.util.JHttpConstant;
import az.rock.ws.publisher.MatcherPublisher;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class JAuthorizationHeaderFilter extends AbstractGatewayFilterFactory<JAuthorizationHeaderFilter.Config> {
    @Value(value = "${rock.security-key}")
    private String encryptKey;
    private final MessageProvider messageProvider;
    private final MatcherPublisher<UserRequestModel> matcherPublisher;

    public JAuthorizationHeaderFilter(MessageProvider messageProvider, MatcherPublisher<UserRequestModel> matcherPublisher) {
        super(Config.class);
        this.messageProvider = messageProvider;
        this.matcherPublisher = matcherPublisher;
    }

    public static class Config {}

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest serverHttpRequest = exchange.getRequest();
            String ipAddress = Objects.requireNonNull(serverHttpRequest.getRemoteAddress()).getAddress().getHostAddress();
            String unauthorizedMessage = this.messageProvider.fail("F_0000000002", this.getLang(serverHttpRequest));

            if (!serverHttpRequest.getHeaders().containsKey(JHttpConstant.AUTHORIZATION))
                return fail(exchange);

            String token = Objects.requireNonNull(serverHttpRequest.getHeaders().get(JHttpConstant.AUTHORIZATION)).get(0).replace(JHttpConstant.BEARER.concat(" "), "");
            Optional<List<String>> optionalPrivateKey = Optional.ofNullable(serverHttpRequest.getHeaders().get(JHttpConstant.USER_PRIVATE_KEY));
            String headerPrivateKey = optionalPrivateKey.orElseThrow(() -> new JRuntimeException("")).get(0);
            if (!this.isValidToken(token,headerPrivateKey,unauthorizedMessage))
                return fail(exchange);
            var claims = this.getClaims(token,headerPrivateKey,unauthorizedMessage);

            //TODO
            var model = UserRequestModel.builder()
                    .withIpAddress(ipAddress)
                    .withUserPrivateKey(headerPrivateKey)
                    .withUserUUID((String) claims.get(JHttpConstant.UUID))
                    .build();

            this.matcherPublisher.publish(UserRequestEvent.of(model));

            ServerHttpRequest request = exchange
                    .getRequest()
                    .mutate()
                    .header(JHttpConstant.ROLE, (String) claims.get(JHttpConstant.ROLE))
                    .header(JHttpConstant.UUID, (String) claims.get(JHttpConstant.UUID))
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    private Mono<Void> fail(ServerWebExchange serverWebExchange) {
        ServerHttpResponse serverHttpResponse = serverWebExchange.getResponse();
        serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
        return serverHttpResponse.setComplete();
    }

    private boolean isValidToken(String token,String headerPrivateKey,String exceptionMessage) {

        try {
            Claims claims = this.getClaims(token,headerPrivateKey,exceptionMessage);
            String uuid = (String) claims.get(JHttpConstant.UUID);
            String role = (String) claims.get(JHttpConstant.ROLE);
            String userPrivateKey = (String) claims.get(JHttpConstant.USER_PRIVATE_KEY);
            return uuid != null && role != null && userPrivateKey.equals(headerPrivateKey);
        } catch (MalformedJwtException malformedJwtException) {
            throw new JSecurityException(exceptionMessage);
        }
    }


    private Claims getClaims(String token,String userPrivateKey,String exceptionMessage) {
        try {
            return Jwts.parser()
                    .setSigningKey(this.encryptKey.concat(userPrivateKey))
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception exception) {
            throw new JSecurityException(exceptionMessage);
        }
    }

    private void checkExpirationDate(String token){
        var decryptedToken = Jwts.parser()
                .setSigningKey(this.encryptKey)
                .parse(token);
    }

    private String getLang(ServerHttpRequest serverHttpRequest) {
        return Objects.requireNonNullElse(serverHttpRequest.getHeaders().get(JHttpConstant.LANG),List.of("en")).get(0);
    }
}
