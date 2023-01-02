package az.rock.lib.kafka.event;

import az.rock.lib.kafka.model.UserRequestModel;

public interface EventPublisher<D> {
    void publish(Event<D> event);
    void onFailure(Throwable throwable);
    void onSuccess(Event<D> event);
}
