package az.rock.ws.auth.rest.privates;

import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.spec.auth.rest.privates.AbstractUserSettingController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/1.0/private/users/settings")
public class UserSettingController implements AbstractUserSettingController {

    private final AbstractJSuccessResponseFactory<?> responseFactory;

    public UserSettingController(AbstractJSuccessResponseFactory<?> responseFactory) {
        this.responseFactory = responseFactory;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<?>> mySettings(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<?>> changeTheme(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<?>>> archive(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<?>> qrCode(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<?>>> marked(JRequest<?> credentials) {
        return null;
    }

    @Override
    public ResponseEntity<JSuccessDataResponse<List<?>>> favorites(JRequest<?> credentials) {
        return null;
    }
}
