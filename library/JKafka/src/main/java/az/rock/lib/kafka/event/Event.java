package az.rock.lib.kafka.event;

import java.io.Serializable;
import java.util.UUID;

public abstract class Event<D> implements Serializable {
    private final UUID eventId = UUID.randomUUID();

    public UUID getEventId() {
        return eventId;
    }

}
