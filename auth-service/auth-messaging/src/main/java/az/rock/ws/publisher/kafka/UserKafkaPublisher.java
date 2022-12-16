package az.rock.ws.publisher.kafka;

import az.rock.lib.adapter.annotation.JEventPublisher;
import az.rock.lib.jdomain.event.AbstractEventPublisher;
import az.rock.lib.jdomain.event.DomainEvent;
import az.rock.ws.aggregate.UserRoot;
import az.rock.ws.event.UserCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
@JEventPublisher
@Qualifier("userKafkaPublisher")
public class UserKafkaPublisher implements AbstractEventPublisher<UserRoot> {
    private static final String USER_CREATED_TOPIC = "USER_CREATED_TOPIC";
    private final KafkaTemplate<String, UserCreatedEvent> kafkaTemplate;

    public UserKafkaPublisher(KafkaTemplate<String, UserCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publish(DomainEvent<UserRoot> event) {
        ListenableFuture<SendResult<String, UserCreatedEvent>> future = kafkaTemplate.send(USER_CREATED_TOPIC, (UserCreatedEvent) event);

        future.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onSuccess(SendResult<String, UserCreatedEvent> result) {
                log.info("Success event on topic :{}",USER_CREATED_TOPIC);
            }
            @Override
            public void onFailure(@NonNull Throwable throwable) {
                log.error("Fail event on topic :{}",USER_CREATED_TOPIC);
            }
        });
    }


}
