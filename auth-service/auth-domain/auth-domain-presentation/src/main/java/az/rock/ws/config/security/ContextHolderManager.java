package az.rock.ws.config.security;

import az.rock.lib.adapter.annotation.JComponent;
import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.util.JHttpConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Objects;

@JComponent
@Slf4j
@Scope(value = "prototype")
@Lazy
public class ContextHolderManager {
    private HashMap<String,String> details;

    public  String lang(){
        this.details = (HashMap<String, String>) SecurityContextHolder.getContext().getAuthentication().getDetails();
        return Objects.requireNonNullElse(this.details.get(JHttpConstant.LANG),"az");
    }


    public  String userUUID(){
        this.details = (HashMap<String, String>) SecurityContextHolder.getContext().getAuthentication().getDetails();
        var uuid = this.details.get(JHttpConstant.UUID);
        return Objects.requireNonNullElseGet(uuid,()->{throw new JSecurityException(); });
    }
}
