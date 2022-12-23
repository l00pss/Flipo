package az.rock.ws.config.security;

import az.rock.ws.config.security.filter.JAuthorizationFilter;
import az.rock.ws.config.security.filter.JPublicFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<JAuthorizationFilter> authFilter(){
        FilterRegistrationBean<JAuthorizationFilter> registrationBean = new FilterRegistrationBean<>();
        log.info("JAuthorizationFilter Run...");
        registrationBean.setFilter(new JAuthorizationFilter());
        registrationBean.addUrlPatterns("/1.0/private/auth/**");
        registrationBean.setOrder(1);
        registrationBean.setEnabled(true);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<JPublicFilter> publicFilter(){
        FilterRegistrationBean<JPublicFilter> registrationBean = new FilterRegistrationBean<>();
        log.info("Public Filter Run.Method..");
        registrationBean.setFilter(new JPublicFilter());
        registrationBean.addUrlPatterns("/1.0/public/auth/**");
        registrationBean.setOrder(2);
        registrationBean.setEnabled(true);
        return registrationBean;
    }

}