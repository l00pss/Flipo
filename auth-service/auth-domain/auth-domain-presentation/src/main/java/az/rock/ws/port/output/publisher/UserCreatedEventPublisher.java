package az.rock.ws.port.output.publisher;

import az.rock.lib.adapter.annotation.JEventPublisher;
import az.rock.lib.jdomain.event.AbstractEventPublisher;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.event.UserCreatedEvent;
import org.springframework.beans.factory.annotation.Qualifier;

@JEventPublisher
public class UserCreatedEventPublisher {

    @Qualifier("userKafkaPublisher")
    private final AbstractEventPublisher<UserRoot> eventPublisher;

    public UserCreatedEventPublisher(AbstractEventPublisher<UserRoot> eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publish(UserCreatedEvent userCreatedEvent){
        this.eventPublisher.publish(userCreatedEvent);
    }
}
