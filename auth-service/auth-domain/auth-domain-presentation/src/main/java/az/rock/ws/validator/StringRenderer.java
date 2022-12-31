package az.rock.ws.validator;

import az.rock.lib.adapter.annotation.JComponent;

import java.util.Locale;

@JComponent
public class StringRenderer {
    public String capitalize(String context){
        return context.substring(0,1).toUpperCase(Locale.ROOT).concat(context.substring(1).toLowerCase(Locale.ROOT));
    }
}
