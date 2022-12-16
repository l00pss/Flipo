package az.rock.lib.jdomain.event;


public interface AbstractEventPublisher<E> {
    void publish(DomainEvent<E> event);
    default  void callback(String topicName){};
}
