package ca.pledgetovote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Tells spring boot where it all starts
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
