package az.rock.ws.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
@AllArgsConstructor
public class CreateUserCommand  {

    private final String username;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
}