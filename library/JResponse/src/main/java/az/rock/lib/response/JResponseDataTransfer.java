package az.rock.lib.response;

import az.rock.lib.JDataTransfer;
import az.rock.lib.JHeader;


public class JResponseDataTransfer<D> extends JDataTransfer<D> {

    private final Boolean success;
    private final String message;

    public JResponseDataTransfer(D data, Boolean success, String message) {
        super(data);
        this.success = success;
        this.message = message;
    }

    public JResponseDataTransfer(JHeader header, D data, Boolean success, String message) {
        super(header, data);
        this.success = success;
        this.message = message;
    }

    public JResponseDataTransfer(D data,Boolean success) {
        super(data);
        this.success = success;
        this.message = null;
    }

    public JResponseDataTransfer(JHeader header, D data,Boolean success) {
        super(header, data);
        this.success = success;
        this.message = null;
    }

}
