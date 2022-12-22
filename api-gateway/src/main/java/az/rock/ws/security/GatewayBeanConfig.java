package az.rock.ws.security;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayBeanConfig {
    @Bean
    public RouteLocator userPrivateLocator(RouteLocatorBuilder routeLocatorBuilder, JAuthorizationHeaderFilter
            authorizationHeaderFilter) {
        return routeLocatorBuilder
                .routes()
                .route(p -> p
                        .path("/auth-service/1.0/private/auth/**")
                        .filters(f -> f.removeRequestHeader("Cookie")
                                .rewritePath("/auth-service/(?<segment>.*)", "/$\\{segment}")
                                .filter(authorizationHeaderFilter.apply(new JAuthorizationHeaderFilter.Config()))
                        )
                        .uri("lb://auth-service")
                )
                .build();
    }

    @Bean
    public RouteLocator userPublicLocator(RouteLocatorBuilder routeLocatorBuilder, JAuthorizationHeaderFilter
            authorizationHeaderFilter) {
        return routeLocatorBuilder
                .routes()
                .route(p -> p
                        .path("/auth-service/1.0/public/auth/**")
                        .filters(f -> f.removeRequestHeader("Cookie")
                                .rewritePath("/auth-service/(?<segment>.*)", "/$\\{segment}")
                        )
                        .uri("lb://auth-service")
                )
                .build();
    }
}
