package az.rock.lib.kafka.event;

import java.io.Serializable;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class Event<D> implements Serializable {
    private final UUID eventId = UUID.randomUUID();

    private final ZonedDateTime time = ZonedDateTime.now(ZoneId.of("UTC"));

    public UUID getEventId() {
        return eventId;
    }

    public ZonedDateTime getTime() {
        return time;
    }
}
