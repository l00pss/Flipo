package az.rock.ws.messenger.publisher;

import az.rock.lib.adapter.annotation.JEventPublisher;
import az.rock.lib.kafka.event.Event;
import az.rock.lib.kafka.event.EventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecord;

@JEventPublisher
@Slf4j
public class MatcherPublisher implements EventPublisher {



    @Override
    public void publish(SpecificRecord model) {

    }

    @Override
    public void handleFailure(Throwable throwable) {

    }

    @Override
    public void handleSuccess(SpecificRecord model) {

    }

}
