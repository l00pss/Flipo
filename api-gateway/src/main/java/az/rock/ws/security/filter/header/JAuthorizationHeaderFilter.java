package az.rock.ws.security.filter.header;

import az.rock.lib.jexception.JRuntimeException;
import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.util.HeaderModel;
import az.rock.ws.messenger.event.UserRequestEvent;
import az.rock.ws.messenger.model.UserRequestEventModel;
import az.rock.lib.message.MessageProvider;
import az.rock.lib.util.JHttpConstant;
import az.rock.ws.messenger.publisher.MatcherPublisher;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@Slf4j
public class JAuthorizationHeaderFilter extends AbstractGatewayFilterFactory<JAuthorizationHeaderFilter.Config> {
    @Value(value = "${rock.security-key}")
    private String encryptKey;
    private final MessageProvider messageProvider;

    public JAuthorizationHeaderFilter(MessageProvider messageProvider) {
        super(Config.class);
        this.messageProvider = messageProvider;
    }

    public static class Config {}

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            log.info("Authorization Filter");
            ServerHttpRequest serverHttpRequest = exchange.getRequest();
            var headerModel = this.checkAndPrepareHeader(exchange);
            if (!serverHttpRequest.getHeaders().containsKey(JHttpConstant.AUTHORIZATION)) return fail(exchange);
            String unauthorizedMessage = this.messageProvider.fail("F_0000000002", headerModel.getLang());

            if (!this.isValidToken(headerModel.getToken(),headerModel.getUserRequestPrivateKey(),unauthorizedMessage))
                return fail(exchange);

            var claims = this.getClaims(headerModel.getToken(),headerModel.getUserRequestPrivateKey(),unauthorizedMessage);
            //TODO
            var model = UserRequestEventModel.builder()
                    .withIpAddress(headerModel.getIpAddress())
                    .withUserPrivateKey(headerModel.getUserRequestPrivateKey())
                    .withUserUUID((String) claims.get(JHttpConstant.UUID))
                    .build();

            //this.matcherPublisher.publish(UserRequestEvent.of(model));

            ServerHttpRequest request = exchange
                    .getRequest()
                    .mutate()
                    .header(JHttpConstant.ROLE, (String) claims.get(JHttpConstant.ROLE))
                    .header(JHttpConstant.UUID, (String) claims.get(JHttpConstant.UUID))
                    .build();
            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    private HeaderModel checkAndPrepareHeader(ServerWebExchange exchange) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        String ipAddress = Objects.requireNonNull(serverHttpRequest.getRemoteAddress()).getAddress().getHostAddress();
        String lang = Objects.requireNonNullElse(serverHttpRequest.getHeaders().get(JHttpConstant.LANG),List.of("az")).get(0);
        List<String> optionalPrivateKey = serverHttpRequest.getHeaders().get(JHttpConstant.USER_PRIVATE_KEY);
        var token = "";
        if(Objects.isNull(optionalPrivateKey) || optionalPrivateKey.isEmpty())
            throw new JSecurityException(this.messageProvider.fail("F_0000000002", lang));
        if (serverHttpRequest.getHeaders().containsKey(JHttpConstant.AUTHORIZATION)){
            token = Objects.requireNonNull(serverHttpRequest.getHeaders().get(JHttpConstant.AUTHORIZATION)).get(0).replace(JHttpConstant.BEARER.concat(" "), "");
        }else throw new JSecurityException(this.messageProvider.fail("F_0000000002", lang));
        return HeaderModel
                .builder()
                .withLang(lang)
                .withIpAddress(ipAddress)
                .withToken(token)
                .build();
    }

    private Mono<Void> fail(ServerWebExchange serverWebExchange) {
        ServerHttpResponse serverHttpResponse = serverWebExchange.getResponse();
        serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
        return serverHttpResponse.setComplete();
    }

    private boolean isValidToken(String token,String headerPrivateKey,String exceptionMessage) {

        try {
            Claims claims = this.getClaims(token,headerPrivateKey,exceptionMessage);
            this.checkExpirationDate(claims,exceptionMessage);
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

    private void checkExpirationDate(Claims claims,String exceptionMessage){
        var expiredDate = claims.getExpiration();
        var now = new Date();
        if(now.after(expiredDate)) throw new JSecurityException(exceptionMessage);
    }

}
