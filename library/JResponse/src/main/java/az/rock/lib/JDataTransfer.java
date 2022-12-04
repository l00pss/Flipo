package az.rock.lib;

public class JDataTransfer<D> extends JTransfer{
    private final D data;

    public JDataTransfer(D data) {
        super();
        this.data = data;
    }

    public JDataTransfer(JHeader header,D data) {
        super(header);
        this.data = data;
    }

    public D getData() {
        return data;
    }
}
