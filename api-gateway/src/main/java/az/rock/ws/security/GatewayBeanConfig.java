package az.rock.ws.security;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayBeanConfig {
    @Bean
    public RouteLocator userRegistryLocator(RouteLocatorBuilder routeLocatorBuilder, JAuthorizationHeaderFilter
            authorizationHeaderFilter) {
        return routeLocatorBuilder
                .routes()
                .route(p -> p
                        .path("/auth-service/users/myprofile/**")
                        .filters(f -> f.removeRequestHeader("Cookie")
                                .rewritePath("/auth-service/(?<segment>.*)", "/$\\{segment}")
                                .filter(authorizationHeaderFilter.apply(new JAuthorizationHeaderFilter.Config())))
                        .uri("lb://auth-service")
                )
                .build();
    }
}
