package az.rock.ws.auth.spec.rest.privates;

import az.rock.lib.annotations.JApiSpec;
import az.rock.lib.annotations.JGet;
import az.rock.lib.annotations.JHead;
import az.rock.lib.annotations.Permission;
import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

@JApiSpec(url = "/1.0/private/auth",permissions = Permission.USER)
public interface AbstractAuthPrivateController {

    @JHead(api = "/live")
    ResponseEntity<JSuccessResponse> live();

    @JGet(api = "/get/{uuid}")
    ResponseEntity<JSuccessDataResponse<?>> get(UUID uuid);

    @JGet(api = "/myProfile")
    ResponseEntity<JSuccessDataResponse<?>> myProfile();


}
