package az.rock.ws.dto.request;

import az.rock.lib.value.generic.JRole;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class CreateUserCommand {

    private final UUID userId;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final JRole role;


    public CreateUserCommand(String username, String firstName, String lastName, String password, String email, JRole role) {
        this.userId = UUID.randomUUID();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.role = role;
    }


}