package az.rock.lib.value.generic;

import java.util.UUID;

public class JViewer {
    private UUID userUUID;

    private Boolean isGuest;

    public JViewer(UUID userUUID, Boolean isGuest) {
        this.userUUID = userUUID;
        this.isGuest = isGuest;
    }
}
