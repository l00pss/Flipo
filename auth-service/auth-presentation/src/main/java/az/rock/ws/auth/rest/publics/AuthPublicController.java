package az.rock.ws.auth.rest.publics;

import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.spec.auth.rest.publics.AbstractAuthPublicController;
import az.rock.ws.dto.request.CreateUserCommand;
import az.rock.ws.port.input.service.abstracts.UserAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/1.0/public/auth")
public class AuthPublicController implements AbstractAuthPublicController {

    private final AbstractJSuccessResponseFactory<?> responseFactory;
    private final UserAuthService userAuthService;

    public AuthPublicController(AbstractJSuccessResponseFactory<?> responseFactory, UserAuthService userAuthService) {
        this.responseFactory = responseFactory;
        this.userAuthService = userAuthService;
    }

    @Override
    @GetMapping("/live")
    public ResponseEntity<JSuccessResponse> live(@RequestBody(required = false) JRequest<?> command) {
        return ResponseEntity.ok(this.responseFactory.factoryResponse("Success"));
    }


    @Override
    @PostMapping("/registry")
    public ResponseEntity<JSuccessDataResponse<?>> registry(JRequest<?> credentials) {
        var createUserResponse = this.userAuthService.createUser((CreateUserCommand) credentials.get());
        var response = this.responseFactory.factoryResponse(createUserResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @GetMapping("/loginSocial")
    public ResponseEntity<JSuccessDataResponse<?>> loginSocial(JRequest<?> credentials) {
        return null;
    }


    @Override
    @PostMapping("/forgotPassword")
    public ResponseEntity<JSuccessDataResponse<?>> forgotPassword(JRequest<?> credentials) {
        return null;
    }
}
