package pl.bdaf.medical_center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bdaf.medical_center.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
