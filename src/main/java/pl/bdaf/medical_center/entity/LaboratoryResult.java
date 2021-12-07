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
@Table(name = "laboratory_result")
public class LaboratoryResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "laboratory_results_sequence")
    @SequenceGenerator(name = "laboratory_results_sequence", sequenceName = "laboratory_results_sequence", allocationSize = 1)
    @Column(name = "result_id", nullable = false)
    private Long resultId;

    @Column(name = "result", length = 1023)
    private String result;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private ResearchOrder order;
}
