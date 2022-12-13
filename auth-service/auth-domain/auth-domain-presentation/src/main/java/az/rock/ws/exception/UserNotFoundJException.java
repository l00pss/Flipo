package az.rock.ws.exception;

import az.rock.lib.jexception.JSecurityException;

public class UserNotFoundJException extends JSecurityException {
    public UserNotFoundJException(String message) {
        super(message);
    }
}
