package az.rock.ws.auth.config;

import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.factory.JSuccessResponseFactory;
import az.rock.lib.message.MessageProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {

    @Bean
    public AbstractJSuccessResponseFactory<?> abstractJSuccessResponseFactory(){
        return new  JSuccessResponseFactory<>();
    }

    @Bean
    public MessageProvider messageProvider(){
        File failFile;
        File successFile;
        try {
            failFile = ResourceUtils.getFile("classpath:fail/auth-service-fail.json");
            successFile = ResourceUtils.getFile("classpath:success/auth-service-success.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return MessageProvider.Builder
                .builder()
                .withFiles(successFile,failFile)
                .build();
    }
}
