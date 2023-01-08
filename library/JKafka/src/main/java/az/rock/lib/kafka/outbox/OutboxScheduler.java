package az.rock.lib.kafka.outbox;

public interface OutboxScheduler {
    void processOutboxMessage();
}
