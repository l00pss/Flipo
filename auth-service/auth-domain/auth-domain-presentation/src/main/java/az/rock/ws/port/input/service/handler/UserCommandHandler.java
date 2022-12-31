package az.rock.ws.port.input.service.handler;

import az.rock.lib.adapter.annotation.JCommandHandler;
import az.rock.lib.message.MessageProvider;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.dto.request.CreateUserCommand;
import az.rock.ws.event.UserCreatedEvent;
import az.rock.ws.exception.UserDomainException;
import az.rock.ws.mapper.UserHandlerDataMapper;
import az.rock.ws.port.output.repository.abstracts.AbstractUserRepository;
import az.rock.ws.service.concretes.UserDomainService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@JCommandHandler
@Slf4j
public class UserCommandHandler {
    private final UserDomainService userDomainService;
    private final AbstractUserRepository userRepository;
    private final UserHandlerDataMapper userDataMapper;
    private final MessageProvider messageProvider;

    public UserCommandHandler(UserDomainService userDomainService, AbstractUserRepository userRepository, UserHandlerDataMapper userDataMapper, MessageProvider messageProvider) {
        this.userDomainService = userDomainService;
        this.userRepository = userRepository;
        this.userDataMapper = userDataMapper;
        this.messageProvider = messageProvider;
    }

    @SneakyThrows(UserDomainException.class)
    @Transactional
    public UserCreatedEvent createdEvent(CreateUserCommand createUserCommand){
        UserRoot userRoot = this.userDataMapper.createUserCommandToUser(createUserCommand);
        UserCreatedEvent userCreatedEvent = this.userDomainService.validateAndInitializeUser(userRoot);
        UserRoot savedUserRoot = this.userRepository.createUser(userRoot);
        if (Objects.isNull(savedUserRoot)){
            log.error("Could not save user with id: {}",userRoot.getId().getValue());
            throw new UserDomainException(this.messageProvider.fail("F_0000000003"));
        }
        log.info("Returning CustomerCreatedEvent for customer id: {}", userRoot.getId().getValue());
        return userCreatedEvent;
    }


}
