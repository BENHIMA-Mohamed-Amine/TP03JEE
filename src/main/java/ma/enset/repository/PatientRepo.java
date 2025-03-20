package ma.enset.repository;

import ma.enset.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
