package az.rock.ws.auth.config;

import az.rock.lib.jresponse.response.factory.AbstractJSuccessResponseFactory;
import az.rock.lib.jresponse.response.factory.JSuccessResponseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public AbstractJSuccessResponseFactory<?> abstractJSuccessResponseFactory(){
        return new  JSuccessResponseFactory<>();
    }
}
