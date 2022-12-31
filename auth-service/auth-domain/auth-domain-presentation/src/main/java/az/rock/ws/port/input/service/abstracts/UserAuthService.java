package az.rock.ws.port.input.service.abstracts;

import az.rock.ws.dto.request.CreateUserCommand;
import az.rock.ws.dto.response.CreateUserResponse;

import javax.validation.Valid;

public interface UserAuthService {
    CreateUserResponse createUser(CreateUserCommand userCommand);
}
