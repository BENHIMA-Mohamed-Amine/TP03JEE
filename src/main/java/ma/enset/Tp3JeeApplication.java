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
}
