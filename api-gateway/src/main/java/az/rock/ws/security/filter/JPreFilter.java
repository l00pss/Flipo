package az.rock.ws.security.filter;

import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.util.JHttpConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Component
@Slf4j
public class JPreFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        var request = exchange.getRequest();
        if(request.getHeaders().get(JHttpConstant.LANG)==null) {
            request.mutate()
                    .header(JHttpConstant.LANG, "en")
                    .build();
        }
        String requestPath = request.getPath().toString();
        log.info("JPreFilter executed Path : {}",requestPath);
        return chain.filter(exchange);
    }
}