package az.rock.ws.auth.spec.rest.privates;

import az.rock.lib.annotations.*;
import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import az.rock.lib.jresponse.response.success.JSuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

@JApiSpec(url = "/1.0/private/users/settings",permissions = Permission.USER)
public interface AbstractUserSettingController {

    @JHead(api = "/live")
    ResponseEntity<JSuccessResponse> live(JRequest<?> command);

    @JGet(api = "/mySettings")
    ResponseEntity<JSuccessDataResponse<?>> mySettings(JRequest<?> credentials);

    @JPost(api = "/change/theme", hasBody = true)
    ResponseEntity<JSuccessDataResponse<?>> changeTheme(JRequest<?> credentials);

    @JGet(api = "/archive")
    ResponseEntity<JSuccessDataResponse<List<?>>> archive(JRequest<?> credentials);

    @JGet(api = "/qrCode")
    ResponseEntity<JSuccessDataResponse<?>> qrCode(JRequest<?> credentials);

    @JGet(api = "/marked")
    ResponseEntity<JSuccessDataResponse<List<?>>> marked(JRequest<?> credentials);

    @JGet(api = "/favorites")
    ResponseEntity<JSuccessDataResponse<List<?>>> favorites(JRequest<?> credentials);
}
