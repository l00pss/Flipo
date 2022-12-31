package az.rock.ws.config.security.filter;

import az.rock.lib.util.JHttpConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@Slf4j
@Component
public class JFilter extends OncePerRequestFilter {
    private final RequestMatcher uriMatcher =  new AntPathRequestMatcher("/**");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String lang = Objects.requireNonNullElse(request.getHeader(JHttpConstant.LANG),"az");
        log.info("Context Lang ".concat(lang));
        SecurityContext context = SecurityContextHolder.getContext();
        AbstractAuthenticationToken auth = (AbstractAuthenticationToken)context.getAuthentication();
        HashMap<String, String> map = new HashMap<>();
        map.put(JHttpConstant.LANG, lang);
        auth.setDetails(map);
        filterChain.doFilter(request,response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        RequestMatcher matcher = new NegatedRequestMatcher(this.uriMatcher);
        return matcher.matches(request);
    }
}
