package az.rock.lib.response.fail;

import az.rock.lib.JHeader;
import az.rock.lib.response.JResponseDataTransfer;

public class JFailDataResponse<D> extends JResponseDataTransfer<D> {
    public JFailDataResponse(D data) {
        super(data, Boolean.FALSE);
    }

    public JFailDataResponse(JHeader header, D data) {
        super(header, data, Boolean.FALSE);
    }

    public JFailDataResponse(D data,String message) {
        super(data, Boolean.FALSE,message);
    }

    public JFailDataResponse(JHeader header, D data,String message) {
        super(header, data, Boolean.FALSE,message);
    }
}
