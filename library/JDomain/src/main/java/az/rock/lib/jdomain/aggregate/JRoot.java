package az.rock.lib.jdomain.aggregate;

import java.util.Objects;

public abstract class JRoot<ID> {
    private ID id;

    public JRoot() {
    }

    public JRoot(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JRoot<?> that = (JRoot<?>) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}