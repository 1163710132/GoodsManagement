package edu.hit.software.se160132;

import edu.hit.software.se160132.entity.Account;
import edu.hit.software.se160132.entity.Permission;
import edu.hit.software.se160132.repository.AccountRepository;
import edu.hit.software.se160132.repository.PermissionRepository;
import edu.hit.software.se160132.repository.StoreRepository;
import edu.hit.software.se160132.security.Role;
import edu.hit.software.se160132.service.InitService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.stream.Stream;

//@SpringBootApplication(scanBasePackages = "edu.hit.software.se160132.*")
@SpringBootApplication
@EnableJpaAuditing
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
        applicationContext.getBean(InitService.class).doInit();
    }
}
