package ma.enset;

import lombok.AllArgsConstructor;
import ma.enset.entities.Patient;
import ma.enset.repository.PatientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
        patientRepo.save(new Patient(null, "Ahmed", new Date(), true, 120));
        patientRepo.save(new Patient(null, "Fatima", new Date(), false, 90));
        patientRepo.save(new Patient(null, "Youssef", new Date(), true, 110));
        patientRepo.save(new Patient(null, "Sara", new Date(), false, 95));
        patientRepo.save(new Patient(null, "Khalid", new Date(), true, 130));

    }
}
