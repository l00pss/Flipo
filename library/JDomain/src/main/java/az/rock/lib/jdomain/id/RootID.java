package az.rock.lib.jdomain.id;

import java.util.Objects;

public abstract class RootID<T> {
    private final T value;

    protected RootID(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootID<?> baseId = (RootID<?>) o;
        return value.equals(baseId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
