package az.rock.ws.dto.request;

import az.rock.lib.value.generic.JRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserCommand {

    private final UUID userId;
    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
    private final JRole role;
}