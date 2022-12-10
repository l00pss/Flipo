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
}