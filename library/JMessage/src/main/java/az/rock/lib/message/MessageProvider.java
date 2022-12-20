package az.rock.lib.message;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MessageProvider {
    private final File successFile;
    private final File failFile;

    private  ObjectMapper objectMapper;
    private Map<String,MessageModel> successMessages = new HashMap<>();
    private Map<String,MessageModel> failMessages = new HashMap<>();

    public MessageProvider(File successFile,File failFile){
        this.objectMapper = new ObjectMapper();
        this.successFile = successFile;
        this.failFile = failFile;
    }

    public void init(){
        try {
            var failList = Arrays.asList(objectMapper.readValue(this.failFile, MessageModel[].class));
            var successList = Arrays.asList(objectMapper.readValue(this.successFile, MessageModel[].class));

            failList.forEach( model->this.failMessages.put(model.getCode(),model));
            successList.forEach( model->this.successMessages.put(model.getCode(),model));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String fail(String code,String lang){
        var model = this.failMessages.get(code);
        if (lang.equals("az")) return model.getAz();
        else return model.getEn();
    }

    public String success(String code,String lang){
        return null;
    }
}
