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
@Table(name = "laboratory_results")
public class LaboratoryResults {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laboratory_results_sequence")
    @SequenceGenerator(name = "laboratory_results_sequence", sequenceName = "laboratory_results_sequence", allocationSize = 1)
    @Column(name = "results_id", nullable = false)
    private Long resultsId;

    @Column(name = "results", length = 1023)
    private String results;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private ResearchOrder order;
}
