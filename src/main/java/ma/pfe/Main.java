package ma.pfe;



import ma.pfe.entities.AppRole;
import ma.pfe.entities.AppUser;
import ma.pfe.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
/*
@SecurityScheme(name = "studentApi", scheme = "basic", type = SecuritySchemeType.HTTP, in = SecuritySchemeIn.HEADER)
*/
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner start(AccountService accountService) {
        return args -> {
            accountService.addNewRole(new AppRole(null, "ROLE_ADMIN"));
            accountService.addNewRole(new AppRole(null, "ROLE_USER"));


            accountService.addNewUser(new AppUser(null, "Med Amine", "test123", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null, "Mohamed", "test123", new ArrayList<>()));

            accountService.addRoleToUser("Med Amine", "ROLE_ADMIN");
            accountService.addRoleToUser("Mohamed", "ROLE_USER");

        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}