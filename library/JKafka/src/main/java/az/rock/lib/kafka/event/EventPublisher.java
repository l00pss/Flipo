package az.rock.lib.kafka.event;

public interface EventPublisher<D> {
    void publish(Event<D> event);
    void onFailure(Throwable throwable);
    void onSuccess(Event<D> event);
}
