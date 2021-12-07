package pl.bdaf.medical_center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bdaf.medical_center.entity.LaboratoryResult;

public interface LaboratoryResultsRepository extends JpaRepository<LaboratoryResult, Long> {
}
