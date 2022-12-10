package az.rock.lib.jdomain.aggregate;

public abstract class JAggregateRoot<ID> extends JRoot<ID> {

    public JAggregateRoot() {
        super();
    }

    public JAggregateRoot(ID id) {
        super(id);
    }
}
