package ma.enset.web;

import lombok.AllArgsConstructor;
import ma.enset.entities.Patient;
import ma.enset.repository.PatientRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    PatientRepo patientRepo;

    @GetMapping("/index")
    public String index(Model model) {
        List<Patient> patients = patientRepo.findAll();
        model.addAttribute("patients", patients);
        return "patients";
    }
}
