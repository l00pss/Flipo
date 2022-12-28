package az.rock.ws.config;

import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.factory.JSuccessResponseFactory;
import az.rock.lib.message.MessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@Configuration
public class BeanConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AbstractJSuccessResponseFactory<?> abstractJSuccessResponseFactory(){
        return new JSuccessResponseFactory<>();
    }


    @Bean
    public MessageProvider messageProvider(){
        File failFile;
        File successFile;
        try {
            failFile = ResourceUtils.getFile("classpath:fail/matcher-service-fail.json");
            successFile = ResourceUtils.getFile("classpath:success/matcher-service-success.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return MessageProvider.Builder
                .builder()
                .withFiles(successFile,failFile)
                .build();
    }
}
