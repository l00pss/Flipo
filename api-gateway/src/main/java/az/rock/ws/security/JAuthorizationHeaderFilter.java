package az.rock.ws.security;

import az.rock.lib.HttpConstant;
import az.rock.lib.jexception.JAuthenticationException;
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

import java.util.Objects;

@Component
public class JAuthorizationHeaderFilter extends AbstractGatewayFilterFactory<JAuthorizationHeaderFilter.Config> {
    @Value(value = "${rock.security-key}")
    private String privateKey;

    public JAuthorizationHeaderFilter(){
        super(Config.class);
    }

    public static class Config{}

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest serverHttpRequest = exchange.getRequest();
            if(!serverHttpRequest.getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
                return fail(exchange,"No authorization header", HttpStatus.UNAUTHORIZED);

            String token = Objects.requireNonNull(serverHttpRequest.getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0).replace(HttpConstant.BEARER.concat(" "),"");
            if (!this.isValidToken(token))
                return fail(exchange,"Token is not Valid!", HttpStatus.UNAUTHORIZED);
            ServerHttpRequest request = exchange
                    .getRequest()
                    .mutate()
                    .header(HttpConstant.ROLE,(String) this.getClaims(token).get(HttpConstant.ROLE))
                    .header(HttpConstant.UUID,(String) this.getClaims(token).get(HttpConstant.UUID))
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    private Mono<Void> fail(ServerWebExchange serverWebExchange, String message, HttpStatus httpStatus){
        ServerHttpResponse serverHttpResponse = serverWebExchange.getResponse();
        serverHttpResponse.setStatusCode(httpStatus);
        return serverHttpResponse.setComplete();
    }

    private boolean isValidToken(String token){
        String fin = null;
        try {
            Claims claims = this.getClaims(token);
            fin = (String) claims.get(HttpConstant.FIN);
            String role = (String) claims.get(HttpConstant.ROLE);

        }catch (MalformedJwtException malformedJwtException){
            throw new JAuthenticationException("Invalid Json Token");
        }
        return Objects.nonNull(fin);
    }


    private Claims getClaims(String token){
        try {
            return  Jwts.parser()
                    .setSigningKey(this.privateKey)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception exception){
            throw new JAuthenticationException("Invalid Json Token");
        }
    }
}
