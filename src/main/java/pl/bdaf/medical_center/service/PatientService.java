package pl.bdaf.medical_center.service;

import pl.bdaf.medical_center.entity.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatients();

    Patient getPatientById(Long aPatientId);

    Patient savePatient(Patient aPatient);

    void deletePatientById(Long aPatientId);

    Patient updatePatientById(Long aPatientId, Patient aPatient);
}
