package az.rock.ws.config.security.filter;

import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.message.MessageProvider;
import az.rock.lib.util.JHttpConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.function.BiConsumer;

@Slf4j


public class JPublicApiFilter extends OncePerRequestFilter {

    @Value(value = "${az.rock.ws.gateway.header-key}")
    private String gatewayKey;

    private final MessageProvider messageProvider;

    private final RequestMatcher uriMatcher = new AntPathRequestMatcher("/1.0/public/auth/**");

    private final BiConsumer<HttpServletRequest, JSecurityException> gatewayKeyControl = (HttpServletRequest request, JSecurityException exception) -> {
        String key =request.getHeader(JHttpConstant.GATEWAY_KEY);
        if (Objects.isNull(key))  throw exception;
        if (!key.equals(this.gatewayKey)) throw exception;
    };

    private final BiConsumer<HttpServletRequest, JSecurityException> langKeyControl = (HttpServletRequest request, JSecurityException exception) -> {
        if (Objects.isNull(request.getHeader(JHttpConstant.LANG))) throw exception;
    };

    public JPublicApiFilter(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.error("Public filter  method Invoked.");
        //var exception = new JSecurityException(this.messageProvider.fail("F_0000000002"));
        //this.gatewayKeyControl.accept(request, exception);
        //this.langKeyControl.accept(request, exception);
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        RequestMatcher matcher = new NegatedRequestMatcher(this.uriMatcher);
        return matcher.matches(request);
    }
}
