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
                .setHeader(KafkaHeaders.GROUP_ID,"api-gateway.per-request-1")
                .build();
        ListenableFuture< SendResult<String,UserRequestEvent<UserRequestEventModel>>> listenable =
                this.kafkaTemplate.send(message);
        listenable.addCallback(new ListenableFutureCallback<>() {
            @Override
            public void onFailure(Throwable ex) {
                handleFailure(ex);
            }

            @Override
            @SuppressWarnings("all")
            public void onSuccess(SendResult<String, UserRequestEvent<UserRequestEventModel>> result) {
                handleSuccess((Event<T>) result.getProducerRecord().value());
            }
        });

    }

    @Override
    public void handleFailure(Throwable throwable) {
        log.info("While kafka publishing ,result is fail");
        throw new JSecurityException();
    }

    @Override
    public void handleSuccess(Event<T> event) {
        log.info("While kafka publishing ,result is success");
    }


}
