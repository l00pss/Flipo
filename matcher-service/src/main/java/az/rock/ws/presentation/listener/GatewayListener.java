package az.rock.ws.presentation.listener;

import az.rock.lib.kafka.consumer.KafkaConsumer;
import az.rock.lib.kafka.topic.AuthTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class GatewayListener implements KafkaConsumer<org.apache.avro.specific.SpecificRecordBase> {


    @Override
    @KafkaListener(topics = AuthTopic.USER_REQUEST, groupId = "gateway.authorization1")
    public void receive(@Payload SpecificRecordBase record,
                        List<String> keys,
                        List<Integer> partitions,
                        List<Long> offsets) {
        log.info(record.toString());
    }
}
