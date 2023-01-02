package az.rock.lib.kafka.event;

public interface EventPublisher<D> {
    void publish(Event<D> event);
}
