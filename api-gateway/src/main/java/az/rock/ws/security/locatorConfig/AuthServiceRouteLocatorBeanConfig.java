package az.rock.ws.security.locatorConfig;

import az.rock.ws.security.filter.header.JAuthorizationHeaderFilter;
import az.rock.ws.security.filter.header.JPublicHeaderFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthServiceRouteLocatorBeanConfig {

    @Value(value = "${az.rock.ws.values.service-names.auth-service}")
    private  String serviceName;

    @Value(value = "${az.rock.ws.values.api.auth.private}")
    private  String privateApi;

    @Value(value = "${az.rock.ws.values.api.auth.public}")
    private  String publicApi;



    @Bean
    public RouteLocator authPrivateLocator(RouteLocatorBuilder routeLocatorBuilder, JAuthorizationHeaderFilter
            authorizationHeaderFilter) {
        return routeLocatorBuilder
                .routes()
                .route(p -> p
                        .path("/".concat(this.serviceName).concat(this.privateApi))
                        .filters(f -> f.removeRequestHeader("Cookie")
                                .rewritePath("/" + this.serviceName + "/(?<segment>.*)", "/$\\{segment}")
                                .filter(authorizationHeaderFilter.apply(new JAuthorizationHeaderFilter.Config()))
                        )
                        .uri("lb://".concat(this.serviceName))
                )
                .build();
    }

    @Bean
    public RouteLocator authPublicLocator(RouteLocatorBuilder routeLocatorBuilder, JPublicHeaderFilter
            publicHeaderFilter) {
        return routeLocatorBuilder
                .routes()
                .route(p -> p
                        .path("/".concat(this.serviceName).concat(this.publicApi))
                        .filters(f -> f.removeRequestHeader("Cookie")
                                .rewritePath("/" + this.serviceName + "/(?<segment>.*)", "/$\\{segment}")
                        )
                        .uri("lb://".concat(this.serviceName))
                )
                .build();
    }
}
