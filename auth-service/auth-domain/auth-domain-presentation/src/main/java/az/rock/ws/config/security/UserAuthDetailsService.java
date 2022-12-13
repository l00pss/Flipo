package az.rock.ws.config.security;

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

    @Value(value = "${az.rock.ws.security-key}")
    private String securityKey;

    @Value(value = "${az.rock.ws.token-exp-time}")
    private String tokenExpDate;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserRoot userRoot = this.userRepository.findByUsername(username);
        if(Objects.isNull(userRoot)) throw new UserNotFoundJException("");

        return new org.springframework.security.core.userdetails.User(
                userRoot.getUsername(), userRoot.getPassword(),
                true,true,
                true,true,new ArrayList<>());
    }

    public UserDetails getUserDetailsByUserName(String userName){
        UserDetails userDetails = this.loadUserByUsername(userName);
        if(Objects.isNull(userDetails)) throw new UserNotFoundJException("");
        return userDetails;
    }

    public UserRoot matches(Authentication authentication){
        String username = ((UserDetails)authentication.getPrincipal()).getUsername();
        return this.userRepository.findByUsername(username);
    }
}
