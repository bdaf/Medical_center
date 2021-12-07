package pl.bdaf.medical_center.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bdaf.medical_center.entity.ResearchOrder;

public interface ResearchOrderRepository extends JpaRepository<ResearchOrder, Long> {
}
