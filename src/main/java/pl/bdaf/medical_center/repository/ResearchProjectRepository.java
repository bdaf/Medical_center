package pl.bdaf.medical_center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bdaf.medical_center.entity.ResearchProject;

public interface ResearchProjectRepository extends JpaRepository<ResearchProject, Long> {
}
