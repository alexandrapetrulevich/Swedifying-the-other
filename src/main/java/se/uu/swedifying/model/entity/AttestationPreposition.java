package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ATTESTATION_PREPOSITION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttestationPreposition {
    @Id
    @GeneratedValue
    @Column(name = "ATTESTATION_PREPOSITION_ID")
    private Long attestationPrepositionId;
}
