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

    @Override
    public void deletePatientById(Long aPatientId) {
        patientRepository.deleteById(aPatientId);
    }

    @Override
    public Patient updatePatientById(Long aPatientId, Patient aPatient) {
        Patient resultPatient = patientRepository.findById(aPatientId).get();

        if(resultPatient == null) return null;

        if (isNotEmpty(aPatient.getName()))
            resultPatient.setName(aPatient.getName());
        if (isNotEmpty(aPatient.getSurname()))
            resultPatient.setSurname(aPatient.getSurname());
        if (isNotEmpty(aPatient.getPesel()))
            resultPatient.setPesel(aPatient.getPesel());
        if (isNotEmpty(aPatient.getEmail()))
            resultPatient.setEmail(aPatient.getEmail());
        if (isNotEmpty(aPatient.getStreet()))
            resultPatient.setStreet(aPatient.getStreet());
        if (isNotEmpty(aPatient.getPostcode()))
            resultPatient.setPostcode(aPatient.getPostcode());
        if (isNotEmpty(aPatient.getHouseNumber()))
            resultPatient.setHouseNumber(aPatient.getHouseNumber());
        if (isNotEmpty(aPatient.getCity()))
            resultPatient.setCity(aPatient.getCity());
        if (isNotEmpty(aPatient.getPhoneNumber()))
            resultPatient.setPhoneNumber(aPatient.getPhoneNumber());

        return patientRepository.save(resultPatient);
    }

    private boolean isNotEmpty(String aValueToCheck) {
        return aValueToCheck != null && !aValueToCheck.equalsIgnoreCase("");
    }
}
