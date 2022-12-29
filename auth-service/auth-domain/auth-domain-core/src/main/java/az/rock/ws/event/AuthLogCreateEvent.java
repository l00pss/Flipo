package az.rock.ws.event;

import az.rock.lib.jdomain.event.DomainEvent;
import az.rock.lib.util.JDateTime;
import az.rock.ws.aggregate.AuthLogRoot;
import az.rock.ws.aggregate.UserRoot;

import java.time.ZonedDateTime;

public class AuthLogCreateEvent implements DomainEvent<AuthLogRoot> {
    private final ZonedDateTime createdAt;

    private final AuthLogRoot userRoot;

    public AuthLogCreateEvent( AuthLogRoot userRoot) {
        this.createdAt = JDateTime.UTC.now();
        this.userRoot = userRoot;
    }

    public static AuthLogCreateEvent of(AuthLogRoot root){
        return new AuthLogCreateEvent(root);
    }
}

