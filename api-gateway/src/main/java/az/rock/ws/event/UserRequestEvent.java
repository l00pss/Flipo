package az.rock.ws.event;

import az.rock.lib.kafka.event.Event;

public class UserRequestEvent<T> extends Event<T> {
    private final T data;

    private UserRequestEvent(T data) {
        this.data = data;
    }

    public static <T> UserRequestEvent<T> of(T data) {
        return new UserRequestEvent<>(data);
    }

    public T getData() {
        return data;
    }
}
