package az.rock.lib.value.generic;

import az.rock.lib.value.annotation.ValueObject;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@ValueObject
public class JPageableRequest<T extends Predicate> {
    private final Integer pageSize;

    private final Integer pageNumber;

    private final List<T> predicates;

    public JPageableRequest(Integer pageSize, Integer pageNumber, List<T> predicates) {
        this.pageSize = Objects.requireNonNullElse(pageSize, 10);
        this.pageNumber = Objects.requireNonNullElse(pageNumber, 1);
        this.predicates = Objects.requireNonNullElse(predicates, Collections.emptyList());
    }
}
