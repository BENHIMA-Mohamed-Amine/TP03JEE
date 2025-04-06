package ma.enset;

import lombok.AllArgsConstructor;
import ma.enset.entities.Patient;
import ma.enset.repository.PatientRepo;
import ma.enset.security.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import java.util.Date;

@SpringBootApplication
@AllArgsConstructor
public class Tp3JeeApplication implements CommandLineRunner {

    PatientRepo patientRepo;

    public static void main(String[] args) {
        SpringApplication.run(Tp3JeeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        patientRepo.save(new Patient(null, "Mohamed", new Date(), false, 100));
        patientRepo.save(new Patient(null, "Ahmed", new Date(), true, 120));
        patientRepo.save(new Patient(null, "Fatima", new Date(), false, 90));
        patientRepo.save(new Patient(null, "Youssef", new Date(), true, 110));
        patientRepo.save(new Patient(null, "Sara", new Date(), false, 95));
        patientRepo.save(new Patient(null, "Khalid", new Date(), true, 130));
        patientRepo.save(new Patient(null, "Hassan", new Date(), false, 85));
        patientRepo.save(new Patient(null, "Imane", new Date(), true, 105));
        patientRepo.save(new Patient(null, "Omar", new Date(), false, 115));
        patientRepo.save(new Patient(null, "Zineb", new Date(), true, 125));
        patientRepo.save(new Patient(null, "Karim", new Date(), false, 140));
        patientRepo.save(new Patient(null, "Salma", new Date(), true, 100));
        patientRepo.save(new Patient(null, "Rachid", new Date(), false, 80));
    }

    @Bean
    CommandLineRunner commandLineRunnerUserDetails(AccountService accountService){
        return args -> {
          accountService.addNewRole("USER");
          accountService.addNewRole("ADMIN");
          accountService.addNewUser("user1", "1234", "1234", "email1");
          accountService.addNewUser("user2", "1234", "1234", "email1");
          accountService.addNewUser("admin", "1234", "1234", "email2");

          accountService.addRoleToUser("user1", "USER");
          accountService.addRoleToUser("user2", "USER");
          accountService.addRoleToUser("admin", "ADMIN");
        };
    }

//    @Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager, PasswordEncoder passwordEncoder) {
//        check if the users already exists
        if(jdbcUserDetailsManager.userExists("user1") && jdbcUserDetailsManager.userExists("admin")) {
            return args -> {};
        }
        return args -> {
            jdbcUserDetailsManager.createUser(
                User.withUsername("user1")
                .password(passwordEncoder.encode("qwer"))
                .roles("USER")
                .build()
            );
            jdbcUserDetailsManager.createUser(
                User.withUsername("admin")
                .password(passwordEncoder.encode("1234"))
                .roles("ADMIN", "USER")
                .build()
            );
        };
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
