package az.rock.ws.port.input.service.concretes;

import az.rock.lib.adapter.annotation.JInputService;
import az.rock.ws.dto.request.CreateUserCommand;
import az.rock.ws.dto.response.CreateUserResponse;
import az.rock.ws.event.UserCreatedEvent;
import az.rock.ws.mapper.UserCommandDataMapper;
import az.rock.ws.port.input.service.abstracts.UserAuthService;
import az.rock.ws.port.input.service.handler.CreateUserCommandHandler;
import az.rock.ws.port.output.publisher.UserCreatedEventPublisher;

@JInputService
public class UserAuthManager implements UserAuthService {
    private final CreateUserCommandHandler userCommandHandler;
    private final UserCommandDataMapper userDataMapper;
    private final UserCreatedEventPublisher userMessagePublisher;

    public UserAuthManager(CreateUserCommandHandler userCommandHandler, UserCommandDataMapper userDataMapper, UserCreatedEventPublisher userMessagePublisher) {
        this.userCommandHandler = userCommandHandler;
        this.userDataMapper = userDataMapper;
        this.userMessagePublisher = userMessagePublisher;
    }

    @Override
    public CreateUserResponse createUser(CreateUserCommand userCommand) {
        UserCreatedEvent userCreatedEvent = this.userCommandHandler.createdEvent(userCommand);
        this.userMessagePublisher.publish(userCreatedEvent);
        return this.userDataMapper.userToCreateUserResponse(userCreatedEvent.getUser(),"User saved successfully!");
    }
}
