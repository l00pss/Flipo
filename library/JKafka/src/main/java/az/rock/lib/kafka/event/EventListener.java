package az.rock.lib.kafka.event;

import az.rock.lib.kafka.event.Event;

public interface EventListener<T> {
    void listen(Event<T> event);
}
