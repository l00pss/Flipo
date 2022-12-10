package az.rock.ws.event;

import az.rock.lib.JDateTime;
import az.rock.lib.event.DomainEvent;
import az.rock.lib.generic.JRole;
import az.rock.ws.aggregate.UserRoot;

import java.time.ZonedDateTime;

public class UserCreatedEvent implements DomainEvent<UserRoot> {

    private final ZonedDateTime createdAt;

    private final UserRoot userRoot;

    private final JRole role;

    public UserCreatedEvent(UserRoot userRoot, JRole role) {
        this.userRoot = userRoot;
        this.createdAt = JDateTime.UTC.now();
        this.role = role;
    }

    public UserRoot getUser() {
        return this.userRoot;
    }

    public String userUUID(){
        return this.userRoot.getId().getValue().toString();
    }

    public JRole getRole() {
        return role;
    }
}
