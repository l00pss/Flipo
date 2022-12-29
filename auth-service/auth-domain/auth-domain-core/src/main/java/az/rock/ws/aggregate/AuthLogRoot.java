package az.rock.ws.aggregate;

import az.rock.lib.jdomain.aggregate.JAggregateRoot;
import az.rock.lib.jdomain.id.UserID;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Getter
@Builder
public class AuthLogRoot extends JAggregateRoot<UserID> {
    private final UUID userUUID;
    private final String username;
    private final String userPrivateKey;
    private final String ipAddress;
    private final Date authDate;
    private final Boolean state;
}