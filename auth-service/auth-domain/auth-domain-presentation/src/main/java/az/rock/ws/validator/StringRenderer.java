package az.rock.ws.validator;

import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class StringRenderer {
    public String capitalize(String context){
        return context.substring(0,1).toUpperCase(Locale.ROOT).concat(context.substring(1).toLowerCase(Locale.ROOT));
    }
}
