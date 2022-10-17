package se.uu.swedifying.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ATTESTATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Attestation {
    @Id
    @GeneratedValue
    @Column(name = "ATTESTATION_ID")
    private Long attestationId;

    @Column(name = "ORIGINAL_FORM")
    private String originalForm;

    @Column(name = "NOTES", columnDefinition = "TEXT")
    private String notes;

    private boolean adaptedToSwedish;

    private String determinationClause;

    private String mainClauseInPhrase;

    private String simpleRootMorpheme;

    private String diversionBase;

    private String mainClauseInSms;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "VARIANT_FORM_ID")
    private AttestationVariantForm variantForm;

    @ManyToOne
    @JoinColumn(name = "LEMMA_FORM_ID")
    private AttestationLemmaForm lemmaForm;

    @ManyToOne
    @JoinColumn(name = "ADAPTATION_TYPE_ID")
    private AdaptationType adaptationType;

    @ManyToMany
    @JoinTable(
            name = "ATTESTATION_PREPOSITION_RELATION"
            , joinColumns = @JoinColumn(name = "ATTESTATION_ID")
            , inverseJoinColumns = @JoinColumn(name = "PREPOSITION_ID"))
    private Set<AttestationPreposition> attestationPrepositions;


    @ManyToOne
    @JoinColumn(name = "MORPHOLOGICAL_NAME_TYPE_ID")
    private MorphologicalNameType morphologicalNameType;

    @ManyToOne
    @JoinColumn(name = "ETYMOLOGY_ID")
    private Etymology etymology;

}
