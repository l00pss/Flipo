package az.rock.ws.config.security.filter;

import javax.servlet.*;
import java.io.IOException;

public class JAuthorizationFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //Tekrar token controlu aparilmalidir.
    }
}
