package az.rock.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MatcherServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MatcherServiceApplication.class,args);
    }
}