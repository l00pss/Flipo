package az.rock.ws.auth.spec.rest.publics;

import az.rock.lib.annotations.*;
import az.rock.lib.jresponse.request.JCommand;
import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import az.rock.ws.dto.request.AuthUserCommand;
import az.rock.ws.dto.request.CreateUserCommand;
import az.rock.ws.dto.response.CreateUserResponse;
import org.springframework.http.ResponseEntity;

@JApiSpec(url = "/1.0/public/auth",permissions = Permission.PUBLIC)
public interface AbstractAuthPublicController {

    @JHead(api = "/live")
    ResponseEntity<JSuccessResponse> live();

    @JGet(api = "/loginSocial")
    ResponseEntity<JSuccessDataResponse<?>> loginSocial(AuthUserCommand authUserCommand);

    @JPost(api = "/registry",hasBody = true)
    ResponseEntity<JSuccessDataResponse<CreateUserResponse>> registry(CreateUserCommand createUserCommand);

    @JPost(api = "/registry",hasBody = true)
    ResponseEntity<JSuccessDataResponse<?>> forgotPassword(String email);


}
