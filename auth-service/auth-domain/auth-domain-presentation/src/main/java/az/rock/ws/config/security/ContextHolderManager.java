package az.rock.ws.config.security;

import az.rock.lib.adapter.annotation.JComponent;
import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.util.JHttpConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Objects;

@JComponent
@Slf4j
@Scope(value = "prototype")
public class ContextHolderManager {
    private HashMap<String,String> details;

    @PostConstruct
    @SuppressWarnings("all")
    public void postConstruct(){
        this.details = (HashMap<String, String>) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }

    public  String lang(){
        log.info("Contex Manager invoked lang .. ");
        return this.details.get(JHttpConstant.LANG);
    }


    public  String userUUID(){
        log.info("Contex Manager invoked lang .. ");
        var uuid = this.details.get(JHttpConstant.UUID);
        return Objects.requireNonNullElseGet(uuid,()->{throw new JSecurityException(); });
    }
}
