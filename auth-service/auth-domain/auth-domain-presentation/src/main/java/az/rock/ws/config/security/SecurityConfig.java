package az.rock.ws.config.security;

import az.rock.ws.config.security.filter.JAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@PropertySource("classpath:application.properties")
@DependsOn({"authenticationEntryPoint"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final GUserDetailsService userDetailsService;
    private final AuthenticationEntryPoint authenticationEntryPoint;

    @Value(value = "${az.rock.ws.gateway.ip-address}")
    private String gateway_ip;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/**").hasIpAddress(this.gateway_ip)
                .and()
                .addFilter(this.getAuthenticationFilter())
                .exceptionHandling()
                .authenticationEntryPoint(this.authenticationEntryPoint);
        http.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    private JAuthenticationFilter getAuthenticationFilter() throws Exception {
        JAuthenticationFilter authenticationFilter = new JAuthenticationFilter(this.userDetailsService,authenticationManager());
        authenticationFilter.setFilterProcessesUrl("/users/auth/login");
        return authenticationFilter;
    }
}
