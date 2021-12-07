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
@Table(name = "consent")
public class Consent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consent_sequence")
    @SequenceGenerator(name = "consent_sequence", sequenceName = "consent_sequence", allocationSize = 1)
    @Column(name = "consent_id", nullable = false)
    private Long consentId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private ResearchProject researchProject;

    @Column(name = "is_connected")
    private Boolean isConnected = false;
}
