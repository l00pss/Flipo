package az.rock.ws.auth.rest.publics;

import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.spec.auth.rest.publics.AbstractUserPublicController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/1.0/public/users")
public class UserPublicController implements AbstractUserPublicController {

    private final AbstractJSuccessResponseFactory<?> responseFactory;

    public UserPublicController(AbstractJSuccessResponseFactory<?> responseFactory) {
        this.responseFactory = responseFactory;
    }

    @Override
    public ResponseEntity<JSuccessResponse> live(JRequest<?> command) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<?>> get(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<?>>> findByName(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<?>>> findByLocation(JRequest<?> credentials) {
        return null;
    }
}
