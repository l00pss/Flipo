package az.rock.ws.config.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Component
@Slf4j
@WebFilter(urlPatterns = "/1.0/public/auth/*")
public class JPublicFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("Public  Run.Method..");
        chain.doFilter(request,response);
    }
}
