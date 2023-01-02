package az.rock.lib.kafka.event;

import az.rock.lib.kafka.event.Event;

public interface EventListener {
    void listen(Event<?> event);
}
