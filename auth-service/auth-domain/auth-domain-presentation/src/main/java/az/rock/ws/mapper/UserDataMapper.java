package az.rock.ws.mapper;


import az.rock.lib.adapter.annotation.JMapper;
import az.rock.lib.jdomain.id.UserID;
import az.rock.lib.value.generic.JRole;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.dto.request.CreateUserCommand;
import az.rock.ws.dto.response.CreateUserResponse;

import java.util.UUID;
@JMapper
public class UserDataMapper {
    public UserRoot createUserCommandToUser(CreateUserCommand command) {
        return UserRoot.Builder
                .builder()
                .withId(UserID.generate())
                .withKey(UUID.randomUUID())
                .withFirstName(command.getFirstName())
                .withLastName(command.getLastName())
                .withEmail(command.getEmail())
                .withUsername(command.getUsername())
                .withPassword(command.getPassword())
                .withRole(JRole.USER)
                .build();
    }

    public CreateUserResponse userToCreateUserResponse(UserRoot customer, String message) {
        return new CreateUserResponse(customer.getId().getValue(), message);
    }
}
