package az.rock.ws.mapper;


import az.rock.lib.adapter.annotation.JMapper;
import az.rock.lib.jdomain.id.UserID;
import az.rock.lib.value.generic.JRole;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.dto.request.CreateUserCommand;
import az.rock.ws.dto.response.CreateUserResponse;
import az.rock.ws.validator.StringRenderer;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Locale;
import java.util.UUID;
@JMapper
public class UserHandlerDataMapper {
    private final PasswordEncoder passwordEncoder;
    private final StringRenderer stringRenderer;

    public UserHandlerDataMapper(PasswordEncoder passwordEncoder, StringRenderer stringRenderer) {
        this.passwordEncoder = passwordEncoder;
        this.stringRenderer = stringRenderer;
    }

    public UserRoot createUserCommandToUser(CreateUserCommand command) {
        return UserRoot.Builder
                .builder()
                .withId(UserID.of())
                .withKey(UUID.randomUUID())
                .withFirstName(this.stringRenderer.capitalize(command.getFirstName().trim()))
                .withLastName(this.stringRenderer.capitalize(command.getLastName().trim()))
                .withEmail(command.getEmail().trim().toLowerCase(Locale.ROOT))
                .withUsername(command.getUsername().trim().toLowerCase(Locale.ROOT))
                .withPassword(passwordEncoder.encode(command.getPassword()))
                .withRole(JRole.USER)
                .withIsActive(Boolean.TRUE)
                .build();
    }

    public CreateUserResponse userToCreateUserResponse(UserRoot customer, String message) {
        return new CreateUserResponse(customer.getId().getValue(), message);
    }
}
