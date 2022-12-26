package az.rock.ws.config.security.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.FilterChainProxy;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

@Slf4j
public class JGenericFilter extends FilterChainProxy {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.error("Generic Filter invoked");
    }
}
