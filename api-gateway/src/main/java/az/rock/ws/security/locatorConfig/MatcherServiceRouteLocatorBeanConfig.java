package az.rock.ws.security.locatorConfig;

import az.rock.ws.security.filter.header.JAuthorizationHeaderFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MatcherServiceRouteLocatorBeanConfig {
    @Value(value = "${az.rock.ws.values.service-names.matcher-service}")
    private  String serviceName;

    @Value(value = "${az.rock.ws.values.api.matcher.feign}")
    private  String feignApi;

    @Bean
    public RouteLocator matcherInnerLocator(RouteLocatorBuilder routeLocatorBuilder) {
        System.out.println(serviceName);
        return routeLocatorBuilder
                .routes()
                .route(p -> p
                        .path("/".concat(this.serviceName).concat(this.feignApi))
                        .filters(f -> f.removeRequestHeader("Cookie")
                                .rewritePath("/" + this.serviceName + "/(?<segment>.*)", "/$\\{segment}")
                                )
                        .uri("lb://".concat(this.serviceName))
                )
                .build();
    }
}
