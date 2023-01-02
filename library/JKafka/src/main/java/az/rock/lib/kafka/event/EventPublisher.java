package az.rock.lib.kafka.event;

public interface EventPublisher<D> {
    void publish(Event<D> event);
    void handleFailure(Throwable throwable);
    void handleSuccess(Event<D> event);
}
