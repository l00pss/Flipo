package az.rock.ws.auth;

import az.rock.ws.auth.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.*;

@SpringBootApplication(exclude = {},
        scanBasePackageClasses = {
                az.rock.ws.config.security.SecurityBeanConfig.class , az.rock.ws.DataAccessConfig.class, BeanConfig.class
        })
@EnableEurekaClient
public class AuthServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}
