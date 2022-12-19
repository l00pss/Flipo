package az.rock.lib.message;

public class JMessageObject {
    private String code;
    private MessageType type;

    public JMessageObject(String code,MessageType type){
        this.code = code;
        this.type = type;
    }

    public String filePostfix(){
        return "-".concat(this.type.get()).concat(".json");
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type.get();
    }
}
