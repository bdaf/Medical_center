package pl.bdaf.medical_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bdaf.medical_center.entity.Patient;
import pl.bdaf.medical_center.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable("id") Long aPatientId){
        return patientService.getPatientById(aPatientId);
    }

    @PostMapping
    public Patient savePatient(@RequestBody Patient aPatient){
        return patientService.savePatient(aPatient);
    }

    @PutMapping("/{id}")
    public Patient updatePatientById(@PathVariable("id") Long aPatientId, @RequestBody Patient aPatient){
        return patientService.updatePatientById(aPatientId, aPatient);
    }

    @DeleteMapping("/{id}")
    public String deletePatientById(@PathVariable("id") Long aPatientId){
        patientService.deletePatientById(aPatientId);
        return "Patient with Id "+ aPatientId + " has been deleted successfully.";
    }

}
