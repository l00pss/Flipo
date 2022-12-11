package az.rock.ws.port.input.service.handler;

import az.rock.lib.adapter.annotation.JCommandHandler;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.dto.request.CreateUserCommand;
import az.rock.ws.event.UserCreatedEvent;
import az.rock.ws.exception.UserDomainException;
import az.rock.ws.mapper.UserDataMapper;
import az.rock.ws.port.output.repository.abstracts.AbstractUserRepository;
import az.rock.ws.service.UserDomainService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@JCommandHandler
@Slf4j
public class CreateUserCommandHandler {
    private final UserDomainService userDomainService;
    private final AbstractUserRepository userRepository;
    private final UserDataMapper userDataMapper;

    public CreateUserCommandHandler(UserDomainService userDomainService, AbstractUserRepository userRepository, UserDataMapper userDataMapper) {
        this.userDomainService = userDomainService;
        this.userRepository = userRepository;
        this.userDataMapper = userDataMapper;
    }

    @SneakyThrows(UserDomainException.class)
    @Transactional
    public UserCreatedEvent createdEvent(CreateUserCommand createUserCommand){
        UserRoot userRoot = this.userDataMapper.createUserCommandToUser(createUserCommand);
        UserCreatedEvent userCreatedEvent = this.userDomainService.validateAndInitializeUser(userRoot);
        UserRoot savedUserRoot = this.userRepository.createUser(userRoot);
        if (Objects.isNull(savedUserRoot)){
            log.error("Could not save user with id: {}",createUserCommand.getUserId());
            throw new UserDomainException("Could not save user with id: {}" + createUserCommand.getUserId());
        }
        log.info("Returning CustomerCreatedEvent for customer id: {}", createUserCommand.getUserId());
        return userCreatedEvent;
    }


}
