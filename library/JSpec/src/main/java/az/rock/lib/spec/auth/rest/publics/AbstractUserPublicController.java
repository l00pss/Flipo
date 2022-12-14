package az.rock.lib.spec.auth.rest.publics;

import az.rock.lib.annotations.JApiSpec;
import az.rock.lib.annotations.JGet;
import az.rock.lib.annotations.JHead;
import az.rock.lib.annotations.Permission;
import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

@JApiSpec(url = "/1.0/public/users",permissions = Permission.PUBLIC)
public interface AbstractUserPublicController {

    @JHead(api = "/live")
    ResponseEntity<JSuccessResponse> live(JRequest<?> command);

    @JGet(api = "/get/{uuid}")
    ResponseEntity<JSuccessDataResponse<?>> get(JRequest<?> credentials);

    @JGet(api = "/findByName")
    ResponseEntity<JSuccessDataResponse<List<?>>> findByName(JRequest<?> credentials);

    @JGet(api = "/findByLocation")
    ResponseEntity<JSuccessDataResponse<List<?>>> findByLocation(JRequest<?> credentials);
}
