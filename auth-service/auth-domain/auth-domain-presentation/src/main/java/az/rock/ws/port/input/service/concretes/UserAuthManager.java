package az.rock.ws.port.input.service.concretes;

import az.rock.ws.dto.request.CreateUserCommand;
import az.rock.ws.dto.response.CreateUserResponse;
import az.rock.ws.port.input.service.abstracts.UserAuthService;

public class UserAuthManager implements UserAuthService {
    @Override
    public CreateUserResponse createUser(CreateUserCommand userCommand) {
        return null;
    }
}
