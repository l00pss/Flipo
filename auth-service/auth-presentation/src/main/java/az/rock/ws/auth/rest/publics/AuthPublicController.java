package az.rock.ws.auth.rest.publics;

import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.spec.auth.rest.publics.AbstractAuthPublicController;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/1.0/public/auth")
public class AuthPublicController implements AbstractAuthPublicController {

    private final AbstractJSuccessResponseFactory<?> responseFactory;

    public AuthPublicController(AbstractJSuccessResponseFactory<?> responseFactory) {
        this.responseFactory = responseFactory;
    }

    @Override
    @GetMapping("/live")
    public ResponseEntity<JSuccessResponse> live(@RequestBody(required = false) JRequest<?> command) {
        return ResponseEntity.ok(this.responseFactory.factoryResponse("Success"));
    }

    @Override
    @GetMapping("/loginSocial")
    public ResponseEntity<JSuccessDataResponse<?>> loginSocial(JRequest<?> credentials) {
        return null;
    }

    @Override
    @PostMapping("/registry")
    public ResponseEntity<JSuccessDataResponse<?>> registry(JRequest<?> credentials) {
        return null;
    }

    @Override
    @PostMapping("/forgotPassword")
    public ResponseEntity<JSuccessDataResponse<?>> forgotPassword(JRequest<?> credentials) {
        return null;
    }
}
