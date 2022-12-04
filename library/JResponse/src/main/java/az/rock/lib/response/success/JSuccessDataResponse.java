package az.rock.lib.response.success;

import az.rock.lib.JHeader;
import az.rock.lib.response.JResponseDataTransfer;

public class JSuccessDataResponse<D> extends JResponseDataTransfer<D> {
    public JSuccessDataResponse(D data) {
        super(data, Boolean.TRUE);
    }

    public JSuccessDataResponse(JHeader header, D data) {
        super(header, data, Boolean.TRUE);
    }

    public JSuccessDataResponse(D data,String message) {
        super(data, Boolean.TRUE,message);
    }

    public JSuccessDataResponse(JHeader header, D data,String message) {
        super(header, data, Boolean.TRUE,message);
    }
}