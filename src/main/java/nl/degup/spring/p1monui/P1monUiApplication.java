package nl.degup.spring.p1monui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class P1monUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(P1monUiApplication.class, args);
    }

}
