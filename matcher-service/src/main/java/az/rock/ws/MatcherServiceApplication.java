package az.rock.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class,scanBasePackages = {
        "az.rock"
})
@EnableEurekaClient
//@ServletComponentScan(basePackageClasses = {az.rock.lib.kafka.consumer.config.KafkaConsumerConfig.class})
public class MatcherServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MatcherServiceApplication.class,args);
    }
}