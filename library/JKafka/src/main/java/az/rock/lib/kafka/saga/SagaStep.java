package az.rock.lib.kafka.saga;

public interface SagaStep<T> {
    void process(T data);
    void rollback(T data);
}
