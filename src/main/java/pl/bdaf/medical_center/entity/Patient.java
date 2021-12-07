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
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    @SequenceGenerator(name = "patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @Column(name = "patient_id", nullable = false)
    private Long patientId;

    @Column(name = "name", length = 31, nullable = false)
    private String name;

    @Column(name = "surname", length = 63, nullable = false)
    private String surname;

    @Column(name = "pesel", length = 15, nullable = false, unique = true)
    private String pesel;

    @Column(name = "email", length = 31, nullable = false, unique = true)
    private String email;

    @Column(name = "street", length = 31)
    private String street;

    @Column(name = "postcode", length = 15, nullable = false)
    private String postcode;

    @Column(name = "house_number", length = 7, nullable = false)
    private String houseNumber;

    @Column(name = "city", length = 31, nullable = false)
    private String city;

    @Column(name = "phone_number", length = 15, nullable = false, unique = true)
    private String phoneNumber;
}
