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

@JApiSpec(url = "/1.0/private/users",permissions = Permission.USER)
public interface AbstractUserPrivateController {

    @JHead(api = "/live")
    ResponseEntity<JSuccessResponse> live(JRequest<?> command);

    @JGet(api = "/get/{uuid}")
    ResponseEntity<JSuccessDataResponse<?>> get(JRequest<?> credentials);

    @JGet(api = "/myProfile")
    ResponseEntity<JSuccessDataResponse<?>> myProfile(JRequest<?> credentials);

    @JGet(api = "/update/profileImage")
    ResponseEntity<JSuccessDataResponse<?>> updateProfileImage(JRequest<?> credentials);

    @JGet(api = "/update/profile")
    ResponseEntity<JSuccessDataResponse<?>> updateProfile(JRequest<?> credentials);

    @JGet(api = "/myProfile/following")
    ResponseEntity<JSuccessDataResponse<List<?>>> myProfileFollowing(JRequest<?> credentials);

    @JGet(api = "/myProfile/followers")
    ResponseEntity<JSuccessDataResponse<List<?>>> myProfileFollowers(JRequest<?> credentials);

    @JGet(api = "/myActions")
    ResponseEntity<JSuccessDataResponse<List<?>>> myActions(JRequest<?> credentials);

    @JGet(api = "/actions")
    ResponseEntity<JSuccessDataResponse<List<?>>> actions(JRequest<?> credentials);
}
