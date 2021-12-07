package pl.bdaf.medical_center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bdaf.medical_center.entity.Consent;

public interface ConsentRepository extends JpaRepository<Consent, Long> {
}
