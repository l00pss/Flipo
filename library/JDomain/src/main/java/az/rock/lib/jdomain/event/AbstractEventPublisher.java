package az.rock.lib.jdomain.event;


public interface AbstractEventPublisher<E> {
    void publish(E event);
}
