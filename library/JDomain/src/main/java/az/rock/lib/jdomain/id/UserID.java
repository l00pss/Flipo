package az.rock.lib.jdomain.id;

import java.util.UUID;

public final class UserID extends RootID<UUID>{

    public UserID(UUID value) {
        super(value);
    }

    public static UserID generate(){
        return new UserID(UUID.randomUUID());
    }
}
