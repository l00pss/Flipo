package az.rock.ws.auth.api.handler;

import az.rock.lib.jresponse.response.factory.AbstractJFailResponseFactory;
import az.rock.lib.jresponse.response.fail.JFailDataResponse;
import az.rock.lib.jresponse.response.fail.JFailResponse;
import az.rock.lib.message.MessageProvider;
import az.rock.ws.exception.InvalidFieldFormatException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@Slf4j
public class UserJExceptionHandler {
    private final MessageProvider messageProvider;
    private final AbstractJFailResponseFactory<?> responseFactory;

    public UserJExceptionHandler(MessageProvider messageProvider, AbstractJFailResponseFactory<?> responseFactory) {
        this.messageProvider = messageProvider;
        this.responseFactory = responseFactory;
    }

    @ExceptionHandler(InvalidFieldFormatException.class)
    public ResponseEntity<JFailResponse> handleContentNotAllowedException(InvalidFieldFormatException exception) {
        log.error("Exception Handler invoked ");
        var response = this.responseFactory.factoryResponse(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
