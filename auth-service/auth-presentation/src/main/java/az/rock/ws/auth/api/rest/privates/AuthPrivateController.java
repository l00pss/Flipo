package az.rock.ws.auth.api.rest.privates;

import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.message.MessageProvider;
import az.rock.ws.auth.spec.rest.privates.AbstractAuthPrivateController;
import az.rock.ws.port.input.service.abstracts.UserAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/1.0/private/auth")
public class AuthPrivateController implements AbstractAuthPrivateController {
    private final AbstractJSuccessResponseFactory<?> responseFactory;
    private final UserAuthService userAuthService;
    private final MessageProvider messageProvider;

    public AuthPrivateController(AbstractJSuccessResponseFactory<?> responseFactory,
                                 UserAuthService userAuthService,
                                 MessageProvider messageProvider) {
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
    public ResponseEntity<JSuccessDataResponse<?>> get(UUID uuid) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<?>> myProfile() {
        return null;
    }
}
