package az.rock.ws.security.filter.header;

import az.rock.lib.message.MessageProvider;
import az.rock.lib.util.JHttpConstant;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class JPublicHeaderFilter extends AbstractGatewayFilterFactory<JPublicHeaderFilter.Config> {
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
            String failMessage = this.messageProvider.fail("F_0000000002", this.getLang(serverHttpRequest));

            ServerHttpRequest request = exchange
                    .getRequest()
                    .mutate()
                    .build();

            return chain.filter(exchange.mutate().request(request).build());
        });
    }

    private Mono<Void> fail(ServerWebExchange serverWebExchange) {
        ServerHttpResponse serverHttpResponse = serverWebExchange.getResponse();
        serverHttpResponse.setStatusCode(HttpStatus.NO_CONTENT);
        return serverHttpResponse.setComplete();
    }

    private String getLang(ServerHttpRequest serverHttpRequest) {
        return Objects.requireNonNull(serverHttpRequest.getHeaders().get(JHttpConstant.LANG)).get(0);
    }
}
