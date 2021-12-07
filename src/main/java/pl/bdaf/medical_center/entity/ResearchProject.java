package pl.bdaf.medical_center.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "research_project")
public class ResearchProject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "research_project_sequence")
    @SequenceGenerator(name = "research_project_sequence", sequenceName = "research_project_sequence", allocationSize = 1)
    @Column(name = "project_id", nullable = false)
    private Long projectId;

    @Column(name = "disease", length = 63, nullable = false, unique = true)
    private String disease;
}
