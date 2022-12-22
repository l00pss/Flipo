package az.rock.ws.security;

import az.rock.lib.jexception.JRuntimeException;
import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.message.MessageProvider;
import az.rock.lib.util.JHttpConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
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
public class JPublicHeaderFilter extends AbstractGatewayFilterFactory<JPublicHeaderFilter.Config> {
    @Value(value = "${rock.security-key}")
    private String encryptKey;
    private final MessageProvider messageProvider;

    public JPublicHeaderFilter(MessageProvider messageProvider) {
        super(Config.class);
        this.messageProvider = messageProvider;
    }

    public static class Config {}

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest serverHttpRequest = exchange.getRequest();
            String unauthorizedMessage = this.messageProvider.fail("F_0000000002", this.getLang(serverHttpRequest));

            if (!serverHttpRequest.getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
                return fail(exchange);

            String token = Objects.requireNonNull(serverHttpRequest.getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0).replace(JHttpConstant.BEARER.concat(" "), "");
            Optional<List<String>> optionalPrivateKey = Optional.ofNullable(serverHttpRequest.getHeaders().get(HttpHeaders.AUTHORIZATION));
            String headerPrivateKey = optionalPrivateKey.orElseThrow(() -> new JRuntimeException("")).get(0);

            ServerHttpRequest request = exchange
                    .getRequest()
                    .mutate()
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    private Mono<Void> fail(ServerWebExchange serverWebExchange) {
        ServerHttpResponse serverHttpResponse = serverWebExchange.getResponse();
        serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
        return serverHttpResponse.setComplete();
    }




    private String getLang(ServerHttpRequest serverHttpRequest) {
        return Objects.requireNonNull(serverHttpRequest.getHeaders().get(JHttpConstant.LANG)).get(0);
    }
}
