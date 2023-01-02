package az.rock.ws.publisher;

import az.rock.lib.adapter.annotation.JEventPublisher;
import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.kafka.event.Event;
import az.rock.lib.kafka.event.EventPublisher;
import az.rock.lib.kafka.event.UserRequestEvent;
import az.rock.lib.kafka.model.UserRequestModel;
import az.rock.lib.kafka.topic.AuthTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.retry.annotation.Retryable;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@JEventPublisher
@Slf4j
public class MatcherPublisher<T> implements EventPublisher<T> {
    private final KafkaTemplate<String,UserRequestEvent<UserRequestModel>> kafkaTemplate;

    public MatcherPublisher(KafkaTemplate<String,UserRequestEvent<UserRequestModel>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Retryable
    public void publish(Event<T> event) {
        log.debug("Event publisher");
        Message<UserRequestEvent<UserRequestModel>> message = MessageBuilder
                .withPayload((UserRequestEvent<UserRequestModel>) event)
                .setHeader(KafkaHeaders.TOPIC, AuthTopic.USER_REQUEST)
                .build();
        ListenableFuture< SendResult<String,UserRequestEvent<UserRequestModel>>> listenable =
                this.kafkaTemplate.send(message);
        listenable.addCallback(new ListenableFutureCallback<SendResult<String, UserRequestEvent<UserRequestModel>>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.debug("While kafka publishing ,result is fail");
                throw new JSecurityException();
            }

            @Override
            public void onSuccess(SendResult<String, UserRequestEvent<UserRequestModel>> result) {
                log.debug("While kafka publishing ,result is success");
            }
        });

    }


}
