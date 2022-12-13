package az.rock.lib.spec.auth.rest.publics;

import az.rock.lib.annotations.*;
import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

@JApiSpec(url = "/1.0/public",permissions = Permission.PUBLIC)
public interface AbstractUserPublicController {

    @JHead(api = "/live")
    ResponseEntity<JSuccessDataResponse<?>> live(JRequest<?> command);

    @JGet(api = "/loginSocial")
    ResponseEntity<JSuccessDataResponse<?>> loginSocial(JRequest<?> credentials);

    @JPost(api = "/registry",hasBody = true)
    ResponseEntity<JSuccessDataResponse<?>> registry(JRequest<?> credentials);

    @JPost(api = "/registry",hasBody = true)
    ResponseEntity<JSuccessDataResponse<?>> forgotPassword(JRequest<?> credentials);


}
