package az.rock.lib.jexception;

public class JSecurityException extends JRuntimeException{
    public JSecurityException(String message) {
        super(message);
    }
    public JSecurityException(String message, Throwable cause) {super(message, cause);}
}
