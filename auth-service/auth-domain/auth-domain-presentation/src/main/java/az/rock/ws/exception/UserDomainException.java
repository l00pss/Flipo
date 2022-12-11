package az.rock.ws.exception;

import az.rock.lib.jexception.JRuntimeException;

public class UserDomainException extends JRuntimeException {
    public UserDomainException(String message) {
        super(message);
    }
}
