package az.rock.ws.config.security;

import az.rock.lib.message.MessageProvider;
import az.rock.ws.config.security.filter.JAuthenticationFilter;
import az.rock.ws.port.input.service.abstracts.AuthLogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
@DependsOn({"authenticationEntryPoint"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserAuthDetailsService userAuthDetailsService;
    private final AuthenticationEntryPoint authenticationEntryPoint;
    private final JAuthenticationProvider authenticationProvider;
    private final MessageProvider messageProvider;
    private final AuthLogService authLogService;

    @Value(value = "${az.rock.ws.gateway.ip-address}")
    private String gateway_ip;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/**")
                .hasIpAddress(this.gateway_ip)
                .and()
                .addFilter(this.getAuthenticationFilter())
                .exceptionHandling()
                .authenticationEntryPoint(this.authenticationEntryPoint);

        http.headers()
                .frameOptions()
                .disable()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.authenticationProvider).eraseCredentials(false);
    }


    private JAuthenticationFilter getAuthenticationFilter() throws Exception {
        JAuthenticationFilter authenticationFilter = new JAuthenticationFilter(this.userAuthDetailsService, super.authenticationManager(), this.messageProvider, this.authLogService);
        authenticationFilter.setFilterProcessesUrl("/1.0/public/auth/login");
        return authenticationFilter;
    }


}
