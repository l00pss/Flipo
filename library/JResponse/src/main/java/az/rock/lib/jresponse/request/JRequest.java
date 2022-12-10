package az.rock.lib.jresponse.request;

import az.rock.lib.jresponse.JDataTransfer;
import az.rock.lib.jresponse.JHeader;

public class JRequest<D> extends JDataTransfer<D> {
    public JRequest(D data) {
        super(data);
    }

    public JRequest(JHeader header, D data) {
        super(header, data);
    }
}
