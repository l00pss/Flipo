package az.rock.lib.response.success;

import az.rock.lib.response.JResponseTransfer;

public class JSuccessResponse extends JResponseTransfer {
    public JSuccessResponse(String message) {
        super(Boolean.TRUE, message);
    }

    public JSuccessResponse() {
        super(Boolean.TRUE);
    }
}
