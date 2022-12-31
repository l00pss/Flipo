package az.rock.ws.auth.api.rest.publics;

import az.rock.lib.jexception.JRuntimeException;
import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.message.MessageProvider;
import az.rock.ws.auth.spec.rest.publics.AbstractAuthPublicController;
import az.rock.ws.dto.request.AuthUserCommand;
import az.rock.ws.dto.request.CreateUserCommand;
import az.rock.ws.dto.response.CreateUserResponse;
import az.rock.ws.port.input.service.abstracts.UserAuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/1.0/public/auth")
public class AuthPublicController implements AbstractAuthPublicController {

    private final AbstractJSuccessResponseFactory<?> responseFactory;
    private final UserAuthService userAuthService;
    private final MessageProvider messageProvider;

    public AuthPublicController(AbstractJSuccessResponseFactory<?> responseFactory, UserAuthService userAuthService, MessageProvider messageProvider) {
        this.responseFactory = responseFactory;
        this.userAuthService = userAuthService;
        this.messageProvider = messageProvider;
    }

    @Override
    @GetMapping("/live")
    public ResponseEntity<JSuccessResponse> live() {
        return ResponseEntity.ok(this.responseFactory.factoryResponse("Success"));
    }


    @Override
    @PostMapping("/registry")
    public ResponseEntity<JSuccessDataResponse<CreateUserResponse>> registry(@RequestBody @Valid CreateUserCommand credentials) {
        var jRequest = JRequest.of(credentials)
                .getThrow(new JRuntimeException(this.messageProvider.fail("F_0000000001","az")));

        var createUserResponse = this.userAuthService.createUser(jRequest);
        var response = this.responseFactory.factoryResponse(createUserResponse);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @GetMapping("/loginSocial")
    public ResponseEntity<JSuccessDataResponse<?>> loginSocial(AuthUserCommand authUserCommand) {
        return null;
    }


    @Override
    @PostMapping("/forgotPassword")
    public ResponseEntity<JSuccessDataResponse<?>> forgotPassword(String email) {
        return null;
    }
}
