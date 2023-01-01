package az.rock.ws.config.security;

import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.message.MessageProvider;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.exception.UserNotFoundJException;
import az.rock.ws.port.output.repository.abstracts.AbstractUserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
@RequiredArgsConstructor
@Getter
public class UserAuthDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final PasswordEncoder passwordEncoder;
    private final AbstractUserRepository userRepository;
    private final MessageProvider messageProvider;
    private final ContextHolderManager contextHolderManager;

    @Value(value = "${az.rock.ws.security-key}")
    private String securityKey;

    @Value(value = "${az.rock.ws.token-exp-time}")
    private String tokenExpDate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRoot userRoot = this.userRepository.findByUsername(username);
        if(Objects.isNull(userRoot)) throw new UserNotFoundJException(this.messageProvider.fail("F_0000000001","en"));
        return new org.springframework.security.core.userdetails.User(userRoot.getUsername(), userRoot.getPassword(),
                userRoot.getIsActive(),true,
                true,userRoot.getIsActive(),new ArrayList<>());
    }

    public UserDetails getUserDetailsByUserName(String userName){
        UserDetails userDetails = this.loadUserByUsername(userName);
        if(Objects.isNull(userDetails)) throw new UserNotFoundJException(this.messageProvider.fail("F_0000000001","en"));
        return userDetails;
    }

    public UserRoot match(Authentication authResult){
        var requestUsername = ((String) authResult.getPrincipal());
        var requestPassword = (String) authResult.getCredentials();
        UserRoot userRoot = this.getUserRoot(requestUsername);
        if (!this.passwordEncoder.matches(requestPassword,userRoot.getPassword()))
            throw new JSecurityException(this.messageProvider.fail("F_0000000001","az"));
        return userRoot;
    }


    public UserRoot getUserRoot(String userName){
        return this.userRepository.findByUsername(userName);
    }
}
