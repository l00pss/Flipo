package az.rock.lib.response.fail;

import az.rock.lib.response.JResponseTransfer;

public class JFailResponse extends JResponseTransfer {
    public JFailResponse(String message) {
        super(Boolean.FALSE, message);
    }

    public JFailResponse() {
        super(Boolean.FALSE);
    }
}
