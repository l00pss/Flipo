package az.rock.ws.exception;

import az.rock.lib.jexception.JAuthenticationException;

public class UserNotFoundJException extends JAuthenticationException {
    public UserNotFoundJException(String message) {
        super(message);
    }
}
