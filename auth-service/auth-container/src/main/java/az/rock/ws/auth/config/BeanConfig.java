package az.rock.ws.auth.config;

import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.factory.JSuccessResponseFactory;
import az.rock.lib.message.MessageProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
@RequiredArgsConstructor
public class BeanConfig {


    @Bean
    public AbstractJSuccessResponseFactory<?> abstractJSuccessResponseFactory(){
        return new  JSuccessResponseFactory<>();
    }

    @Bean
    public MessageProvider messageProvider(){
        File failFile = new File("src/main/resources/fail/auth-service-fail.json");
        File successFile = new File("src/main/resources/success/auth-service-success.json");
        return MessageProvider.Builder
                .builder()
                .withFailFile(failFile)
                .withSuccessFile(successFile)
                .build();
    }
}
