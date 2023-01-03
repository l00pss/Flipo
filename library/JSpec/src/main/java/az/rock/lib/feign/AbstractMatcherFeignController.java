package az.rock.lib.feign;

import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;

public interface AbstractMatcherFeignController {
    JSuccessDataResponse<String> loginUser(JRequest<String> model);
}
