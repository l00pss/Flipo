package az.rock.lib.message;

public enum MessageType {
    SUCCESS("success"),FAIL("fail");

    private final String result;
    MessageType(String result) {
        this.result = result;
    }

    public String get() {
        return result;
    }
}
