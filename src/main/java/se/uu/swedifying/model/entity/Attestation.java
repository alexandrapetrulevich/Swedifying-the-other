package se.uu.swedifying.model.entity;

import lombok.*;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "VARIANT_FORM_ID")
    private AttestationVariantForm variantForm;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "SOURCE_FINDING_ID")
    private SourceFinding sourceFinding;

    @Column(name = "NOTES", columnDefinition = "TEXT")
    private String notes;

}
