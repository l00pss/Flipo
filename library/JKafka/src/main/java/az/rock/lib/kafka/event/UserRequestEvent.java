package az.rock.lib.kafka.event;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class UserRequestEvent <T> extends Event<T>{
    private final ZonedDateTime time = ZonedDateTime.now(ZoneId.of("UTC"));
    private final T data;

    private UserRequestEvent(T data){
        this.data = data;
    }
    public static <T> UserRequestEvent<T> of(T data){
        return new UserRequestEvent<>(data);
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public T getData() {
        return data;
    }
}
