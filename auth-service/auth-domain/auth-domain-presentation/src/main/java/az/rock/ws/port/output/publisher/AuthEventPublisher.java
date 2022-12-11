package az.rock.ws.port.output.publisher;

import az.rock.lib.adapter.annotation.JEventPublisher;
import az.rock.lib.jdomain.event.AbstractEventPublisher;
import az.rock.lib.kafka.topic.AuthTopic;
import az.rock.lib.util.JHttpConstant;
import az.rock.ws.event.UserCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;

@JEventPublisher
public class AuthEventPublisher implements AbstractEventPublisher<UserCreatedEvent> {
    private final KafkaTemplate<String,String> kafkaTemplate;

    public AuthEventPublisher(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(UserCreatedEvent event) {
        this.kafkaTemplate.send(AuthTopic.USER_CREATED, JHttpConstant.UUID,event.userUUID());
    }
}
