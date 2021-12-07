package pl.bdaf.medical_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bdaf.medical_center.entity.Patient;
import pl.bdaf.medical_center.repository.PatientRepository;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long aPatientId) {
        return patientRepository.findById(aPatientId).get();
    }

    @Override
    public Patient savePatient(Patient aPatient) {
        return patientRepository.save(aPatient);
    }
}
