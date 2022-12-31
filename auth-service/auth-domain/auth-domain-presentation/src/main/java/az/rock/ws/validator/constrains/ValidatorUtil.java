package az.rock.ws.validator.constrains;

import az.rock.lib.adapter.annotation.JComponent;
import az.rock.lib.message.MessageProvider;
import az.rock.ws.exception.InvalidFieldFormatException;

import java.util.function.BiConsumer;

@JComponent
public class ValidatorUtil {

    public BiConsumer<String, String> checkEmpty = (String value, String message) -> {
        if ((value == null || value.trim().equals("")))
            throw new InvalidFieldFormatException(message);
    };

    public BiConsumer<String, String> checkEmailFormat = (String value, String message) -> {
        if (!value.trim().contains("@") || !value.trim().contains(".") || value.trim().startsWith(".")
                || value.trim().endsWith(".") || value.trim().startsWith("@") || value.trim().endsWith("@"))
            throw new InvalidFieldFormatException(message);
    };
}
