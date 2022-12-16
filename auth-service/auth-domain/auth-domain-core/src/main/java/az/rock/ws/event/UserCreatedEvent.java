package az.rock.ws.event;

import az.rock.lib.jdomain.event.auth.AuthDomainEvent;
import az.rock.lib.util.JDateTime;
import az.rock.lib.value.generic.JRole;
import az.rock.ws.aggregate.UserRoot;

import java.time.ZonedDateTime;

public class UserCreatedEvent implements AuthDomainEvent<UserRoot> {

    private final ZonedDateTime createdAt;

    private final UserRoot userRoot;


    public UserCreatedEvent(UserRoot userRoot) {
        this.userRoot = userRoot;
        this.createdAt = JDateTime.UTC.now();
    }

    public static UserCreatedEvent of(UserRoot root){
        return new UserCreatedEvent(root);
    }

    public UserRoot getUser() {
        return this.userRoot;
    }

    public String userUUID(){
        return this.userRoot.getId().getValue().toString();
    }

}
