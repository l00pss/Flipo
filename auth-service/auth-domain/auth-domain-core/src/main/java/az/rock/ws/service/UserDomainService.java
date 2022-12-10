package az.rock.ws.service;

import az.rock.lib.annotation.JDomainService;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@JDomainService
public class UserDomainService implements AbstractUserDomainService{
    @Override
    public UserCreatedEvent validateAndInitializeUser(UserRoot userRoot) {
        log.info("Customer with id: {} is initiated", userRoot.getId().getValue());
        return new UserCreatedEvent(userRoot, userRoot.getRole());
    }
}