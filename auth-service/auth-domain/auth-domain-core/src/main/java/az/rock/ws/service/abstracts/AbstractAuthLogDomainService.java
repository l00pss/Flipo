package az.rock.ws.service.abstracts;

import az.rock.ws.aggregate.AuthLogRoot;
import az.rock.ws.event.AuthLogCreateEvent;

public interface AbstractAuthLogDomainService {
    AuthLogCreateEvent validateAndInitializeUser(AuthLogRoot root) ;
}
