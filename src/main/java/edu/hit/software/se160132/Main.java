package edu.hit.software.se160132;

import edu.hit.software.se160132.service.impl.InitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@SpringBootApplication(scanBasePackages = "edu.hit.software.se160132.*")
@SpringBootApplication
@EnableJpaAuditing
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        applicationContext.getBean(InitService.class).doInit();
    }
}
