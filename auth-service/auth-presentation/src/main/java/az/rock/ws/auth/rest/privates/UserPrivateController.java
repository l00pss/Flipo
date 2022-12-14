package az.rock.ws.auth.rest.privates;

import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.lib.spec.auth.rest.privates.AbstractUserPrivateController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/1.0/private/users")
public class UserPrivateController implements AbstractUserPrivateController {

    private final AbstractJSuccessResponseFactory<?> responseFactory;

    public UserPrivateController(AbstractJSuccessResponseFactory<?> responseFactory) {
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
    public ResponseEntity<JSuccessDataResponse<?>> myProfile(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<?>> updateProfileImage(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<?>> updateProfile(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<?>>> myProfileFollowing(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<?>>> myProfileFollowers(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<?>>> myActions(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<?>>> actions(JRequest<?> credentials) {
        return null;
    }
}
