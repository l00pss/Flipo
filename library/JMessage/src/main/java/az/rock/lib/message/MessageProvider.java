package az.rock.lib.message;

import java.io.File;
import java.util.Objects;

public class MessageProvider {
    private final String serviceName;
    private String fileName;
    private File successFile;
    private File failFile;

    public MessageProvider(String serviceName){
        this.serviceName = serviceName;
        this.successFile = new File("az/rock/lib/message/success/".concat(this.serviceName).concat("-success.json"));
        this.failFile = new File("az/rock/lib/message/fail/".concat(this.serviceName).concat("-fail.json"));
    }
    public String fail(JMessageObject messageObject){

        return null;
    }

    public String success(JMessageObject messageObject){

        return null;
    }
}
