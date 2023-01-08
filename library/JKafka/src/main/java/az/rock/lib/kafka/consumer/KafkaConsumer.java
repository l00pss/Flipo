package az.rock.lib.kafka.consumer;

import org.apache.avro.specific.SpecificRecordBase;

import java.util.List;

public interface KafkaConsumer<T extends SpecificRecordBase> {
    void receive(T record, List<String> keys, List<Integer> partitions, List<Long> offsets);
}
