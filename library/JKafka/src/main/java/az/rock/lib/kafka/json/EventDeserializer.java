package az.rock.lib.kafka.json;

import az.rock.lib.jexception.JRuntimeException;
import az.rock.lib.kafka.event.Event;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class EventDeserializer implements Deserializer<Event<?>> {

    private final transient ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Event<?> deserialize(String topic, byte[] data) {
        var value = new String(data, StandardCharsets.UTF_8);
        try {
            return this.objectMapper.readValue(value,Event.class);
        } catch (JsonProcessingException e) {
            throw new JRuntimeException();
        }
    }

    @Override
    public Event<?> deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
