package az.rock.ws.messenger.publisher;

import az.rock.lib.adapter.annotation.JEventPublisher;
import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.kafka.event.Event;
import az.rock.lib.kafka.event.EventPublisher;
import az.rock.ws.messenger.model.UserRequestEventModel;
import az.rock.ws.messenger.event.UserRequestEvent;
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
    private final KafkaTemplate<String,UserRequestEvent<UserRequestEventModel>> kafkaTemplate;

    public MatcherPublisher(KafkaTemplate<String,UserRequestEvent<UserRequestEventModel>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    @Retryable
    public void publish(Event<T> event) {
        log.debug("Event publisher");
        Message<UserRequestEvent<UserRequestEventModel>> message = MessageBuilder
                .withPayload((UserRequestEvent<UserRequestEventModel>) event)
                .setHeader(KafkaHeaders.TOPIC, AuthTopic.USER_REQUEST)
                .build();
        ListenableFuture< SendResult<String,UserRequestEvent<UserRequestEventModel>>> listenable =
                this.kafkaTemplate.send(message);
        listenable.addCallback(new ListenableFutureCallback<SendResult<String, UserRequestEvent<UserRequestEventModel>>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.debug("While kafka publishing ,result is fail");
                throw new JSecurityException();
            }

            @Override
            public void onSuccess(SendResult<String, UserRequestEvent<UserRequestEventModel>> result) {
                log.debug("While kafka publishing ,result is success");
            }
        });

    }

    @Override
    public void onFailure(Throwable throwable) {

    }

    @Override
    public void onSuccess(Event<T> event) {

    }


}
