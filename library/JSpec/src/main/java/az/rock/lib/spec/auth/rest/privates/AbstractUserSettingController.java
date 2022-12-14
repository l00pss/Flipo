package az.rock.lib.spec.auth.rest.privates;

import az.rock.lib.annotations.JApiSpec;
import az.rock.lib.annotations.JGet;
import az.rock.lib.annotations.JPost;
import az.rock.lib.annotations.Permission;
import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

@JApiSpec(url = "/1.0/private/users/settings",permissions = Permission.USER)
public interface AbstractUserSettingController {
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
