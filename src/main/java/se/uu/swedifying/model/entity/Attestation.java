package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ATTESTATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Attestation {
    @Id
    @GeneratedValue
    @Column(name = "ATTESTATION_ID")
    private Long attestationId;

    @Column(name = "ORIGINAL_FORM")
    private String originalForm;

    @Column(name = "NOTES", columnDefinition = "TEXT")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "VARIANT_FORM_ID")
    private AttestationVariantForm variantForm;

    @ManyToOne
    @JoinColumn(name = "LEMMA_FORM_ID")
    private AttestationLemmaForm lemmaForm;

    @ManyToMany
    @JoinTable(
            name = "ATTESTATION_PREPOSITION_RELATION"
            , joinColumns = @JoinColumn(name = "ATTESTATION_ID")
            , inverseJoinColumns = @JoinColumn(name = "PREPOSITION_ID"))
    private Set<AttestationPreposition> attestationPrepositions;

    @Builder
    private Attestation(long attestationId, String originalForm, Location location) {
        this.attestationId = attestationId;
        this.originalForm = originalForm;
        this.location = location;
    }

}
