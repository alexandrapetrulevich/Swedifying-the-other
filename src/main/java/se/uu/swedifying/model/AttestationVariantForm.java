package se.uu.swedifying.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ATTESTATION_VARIANT_FORM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttestationVariantForm {
    @Id
    @GeneratedValue
    @Column(name = "ATTESTATION_VARIANT_FORM_ID")
    private Long attestationVariantFormId;
}
