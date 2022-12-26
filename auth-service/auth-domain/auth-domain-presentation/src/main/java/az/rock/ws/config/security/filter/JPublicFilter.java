package az.rock.ws.config.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class JPublicFilter extends DelegatingFilterProxy {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.error("JPublicFilter Method Invoked.");
        chain.doFilter(request,response);
    }
}
