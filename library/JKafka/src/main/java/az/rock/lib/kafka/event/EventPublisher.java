package az.rock.lib.kafka.event;

public interface EventPublisher {
    void publish(org.apache.avro.specific.SpecificRecord model);
    void handleFailure(Throwable throwable);
    void handleSuccess(org.apache.avro.specific.SpecificRecord model);
}
