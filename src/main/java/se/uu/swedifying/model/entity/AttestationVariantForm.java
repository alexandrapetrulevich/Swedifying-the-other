package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import se.uu.swedifying.model.util.Language;

import javax.persistence.*;

@Entity
@Table(name = "ATTESTATION_VARIANT_FORM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttestationVariantForm {
    @Id
    @GeneratedValue
    @Column(name = "VARIANT_FORM_ID")
    private Long variantFormId;

    @Column(name = "VARIANT_FORM_NAME")
    private String variantFormName;

    @Column(name = "VARIANT_FORM_LANGUAGE")
    private Language variantFormLanguage;

    @ManyToOne
    @JoinColumn(name = "VARIANT_FORM_LOCATION_ID")
    private Location variantFormLocation;
}
