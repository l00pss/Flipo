package az.rock.ws.messenger;

import az.rock.lib.adapter.annotation.JEventListener;
import az.rock.lib.kafka.event.Event;
import az.rock.lib.kafka.event.EventListener;
import az.rock.lib.kafka.topic.AuthTopic;
import az.rock.ws.domain.core.event.UserRequestEvent;
import az.rock.ws.domain.core.event.model.UserRequestEventModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;

@JEventListener
@Slf4j
public class UserRequestListener implements EventListener {

    @Override
    @KafkaListener(topics = AuthTopic.USER_REQUEST,groupId = "api-gateway.per-request-1")
    public void listen(Event<?> event) {
        //var model = ((UserRequestEvent<UserRequestEventModel>) event).getData();
        log.info("Model is : ");
    }
}
