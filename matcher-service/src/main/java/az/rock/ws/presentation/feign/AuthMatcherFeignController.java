package az.rock.ws.presentation.feign;

import az.rock.lib.feign.AbstractMatcherFeignController;
import az.rock.lib.jresponse.request.JRequest;
import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.success.JSuccessDataResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/1.0/private/matcher")
public class AuthMatcherFeignController implements AbstractMatcherFeignController {

    private final AbstractJSuccessResponseFactory<String> responseFactory;

    public AuthMatcherFeignController(AbstractJSuccessResponseFactory<String> responseFactory) {
        this.responseFactory = responseFactory;
    }

    @Override
    @PostMapping(value = "/loginUser")
    public JSuccessDataResponse<String> loginUser(@RequestBody JRequest<String> model) {
        String name = model.isPresent() ? model.get() : "Bos deyer";
        return responseFactory.factoryResponse(name,"Message");
    }
}
