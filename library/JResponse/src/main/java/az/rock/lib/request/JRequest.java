package az.rock.lib.request;

import az.rock.lib.JDataTransfer;
import az.rock.lib.JHeader;

public class JRequest<D> extends JDataTransfer<D> {
    public JRequest(D data) {
        super(data);
    }

    public JRequest(JHeader header, D data) {
        super(header, data);
    }
}
