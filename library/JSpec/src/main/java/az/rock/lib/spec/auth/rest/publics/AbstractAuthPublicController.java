package az.rock.lib.spec.auth.rest.publics;

import az.rock.lib.annotations.*;
import az.rock.lib.jresponse.request.JCommand;
import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

@JApiSpec(url = "/1.0/public/auth",permissions = Permission.PUBLIC)
public interface AbstractAuthPublicController {

    @JHead(api = "/live")
    ResponseEntity<JSuccessResponse> live(JRequest<?> command);

    @JGet(api = "/loginSocial")
    ResponseEntity<JSuccessDataResponse<?>> loginSocial(JRequest<?> credentials);

    @JPost(api = "/registry",hasBody = true)
    ResponseEntity<JSuccessDataResponse<?>> registry(JRequest<?> credentials);

    @JPost(api = "/registry",hasBody = true)
    ResponseEntity<JSuccessDataResponse<?>> forgotPassword(JRequest<?> credentials);


}
