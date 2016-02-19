package qcom.cas.sample.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "qcom.cas.sample.redis", "qcom.cas.sample.websocket" })
public class Application {
    public static void main( String[] args ) {
        SpringApplication.run(Application.class, args);
    }
}
