package se.uu.swedifying.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ATTESTATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Attestation {
    @Id
    @GeneratedValue
    @Column(name = "ATTESTATION_ID")
    private Long attestationId;

    @Column(name = "ORIGINAL_FORM")
    private String originalForm;

}
