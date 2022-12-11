package az.rock.ws.port.output.publisher;

import az.rock.lib.jdomain.event.AbstractEventPublisher;
import az.rock.ws.event.UserCreatedEvent;

public class AuthEventPublisher implements AbstractEventPublisher<UserCreatedEvent> {
    @Override
    public void publish(UserCreatedEvent event) {

    }
}
