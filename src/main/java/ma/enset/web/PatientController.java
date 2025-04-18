package ma.enset.web;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.enset.entities.Patient;
import ma.enset.repository.PatientRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@AllArgsConstructor
public class PatientController {
    PatientRepo patientRepo;

    @GetMapping("/index")
    public String index(
            Model model,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "4") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        Page<Patient> pagePatients = patientRepo.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("patients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String delete(Long id, String keyword, int page) {
        patientRepo.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/patients")
    @ResponseBody
    public List<Patient> listPatients(){
        return patientRepo.findAll();
    }

    @GetMapping("/formPatient")
    public String patientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "patientForm";
    }

    @PostMapping("/save")
    public String save(@Valid Patient patient, BindingResult bindingResult,
                    @RequestParam(name = "page", defaultValue = "0") int page,
                    @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        if (bindingResult.hasErrors()) {
            return "patientForm";
        }
        patientRepo.save(patient);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/editPatient")
    public String editPatient(Model model, Long id, @RequestParam(name="keyword", value = "") String keyword, @RequestParam(name="page") int page) {
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));
        model.addAttribute("patient", patient);
        model.addAttribute("page", page);
        model.addAttribute("keyword", keyword);
        return "patientForm";
    }
}
