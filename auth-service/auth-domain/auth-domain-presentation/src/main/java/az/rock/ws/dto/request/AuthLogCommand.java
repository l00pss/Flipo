package az.rock.ws.dto.request;

import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Builder
@Getter
public final class AuthLogCommand {
    private final UUID userUUID;
    private final String username;
    private final String userPrivateKey;
    private final String ipAddress;
    private final Date authDate = new Date();
    private final Boolean state = Boolean.TRUE;

}
