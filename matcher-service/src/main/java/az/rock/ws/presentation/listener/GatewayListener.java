package az.rock.ws.presentation.listener;

import az.rock.lib.kafka.model.ConsumerGatewayRequest;
import az.rock.lib.kafka.topic.AuthTopic;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GatewayListener {

    @KafkaListener(topics = AuthTopic.USER_REQUEST, groupId = "gateway.authorization")
    public void listen(@Payload ConsumerGatewayRequest record) {
        log.info(record.toString());
    }

}
