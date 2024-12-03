import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan({"springsecurity"})
public class SpringBootSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootSecurityApplication.class);
    }
}
