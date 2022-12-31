package az.rock.ws.exception;

import az.rock.lib.jexception.JRuntimeException;

public class InvalidFieldFormatException extends UserDomainException {
    public InvalidFieldFormatException(String message){
        super(message);
    }
    public InvalidFieldFormatException(String message, Throwable cause) {super(message, cause);}
}
