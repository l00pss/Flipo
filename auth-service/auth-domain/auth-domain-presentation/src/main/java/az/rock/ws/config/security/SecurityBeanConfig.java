package az.rock.ws.config.security;

import az.rock.ws.config.security.handler.JAccessDeniedHandler;
import az.rock.ws.config.security.handler.JAuthenticationFailureHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
public class SecurityBeanConfig {
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new JAuthenticationFailureHandler();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new JAccessDeniedHandler();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new JAuthenticationEntryPoint();
    }
}
