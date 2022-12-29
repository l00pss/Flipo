package az.rock.ws.service.concretes;

import az.rock.lib.adapter.annotation.JDomainService;
import az.rock.ws.aggregate.AuthLogRoot;
import az.rock.ws.event.AuthLogCreateEvent;
import az.rock.ws.service.abstracts.AbstractAuthLogDomainService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@JDomainService
public class AuthLogDomainService implements AbstractAuthLogDomainService {

    @Override
    public AuthLogCreateEvent validateAndInitializeUser(AuthLogRoot root) {
        log.info("Auth Log  with id: {} is initiated", root.getId());
        return AuthLogCreateEvent.of(root);
    }
}
