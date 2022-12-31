package az.rock.ws.dto.request;

import az.rock.lib.jresponse.request.JCommand;
import az.rock.ws.validator.annotations.JEmailConstraint;
import az.rock.ws.validator.annotations.JPasswordConstraint;
import az.rock.ws.validator.annotations.JTextConstraint;
import az.rock.ws.validator.annotations.JUsernameConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Builder
@AllArgsConstructor
@Setter
public class CreateUserCommand extends JCommand {

    @JUsernameConstraint(unique = true)
    private final String username;
    @JTextConstraint
    private final String firstName;
    @JTextConstraint
    private final String lastName;
    @JPasswordConstraint
    private final String password;
    @JEmailConstraint
    private final String email;
}