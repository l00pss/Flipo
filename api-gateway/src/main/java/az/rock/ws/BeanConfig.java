package az.rock.ws;

import az.rock.lib.message.MessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Configuration
public class BeanConfig {

    @Bean
    public MessageProvider messageProvider(){
        File failFile;
        File successFile;
        try {
            failFile = ResourceUtils.getFile("classpath:fail/api-gateway-fail.json");
            successFile = ResourceUtils.getFile("classpath:success/api-gateway-success.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return MessageProvider.Builder
                .builder()
                .withFiles(successFile,failFile)
                .build();
    }
}
