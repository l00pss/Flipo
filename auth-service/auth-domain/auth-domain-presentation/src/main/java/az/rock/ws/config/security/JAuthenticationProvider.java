package az.rock.ws.config.security;

import az.rock.lib.adapter.annotation.JComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.ArrayList;

@JComponent
@Slf4j
public class JAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.debug("JAuthenticationProvider invoked");
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        return new UsernamePasswordAuthenticationToken( name, password, new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
