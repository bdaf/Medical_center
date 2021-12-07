package pl.bdaf.medical_center.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "research_order")
public class ResearchOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "research_date", nullable = false)
    private Date researchDate;

    @ManyToOne
    @JoinColumn(name = "consent_id", referencedColumnName = "consent_id", nullable = false)
    private Consent consent;
}
