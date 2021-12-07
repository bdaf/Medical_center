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

    @PostMapping("/save")
    public Patient savePatient(@RequestBody Patient aPatient){
        return patientService.savePatient(aPatient);
    }
}
