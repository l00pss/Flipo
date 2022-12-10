package az.rock.ws.service;

import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.event.UserCreatedEvent;

public interface AbstractUserDomainService {
    UserCreatedEvent validateAndInitializeUser(UserRoot userRoot);
}
