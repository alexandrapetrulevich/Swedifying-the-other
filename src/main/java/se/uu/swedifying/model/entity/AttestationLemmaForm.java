package se.uu.swedifying.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ATTESTATION_LEMMA_FORM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AttestationLemmaForm {
    @Id
    @GeneratedValue
    @Column(name = "LEMMA_FORM_ID")
    private Long lemmaFormId;

    @Column(name = "LEMMA_FORM_NAME")
    private String lemmaFormName;

    @ManyToOne
    @JoinColumn(name = "LEMMA_FORM_LOCATION_ID")
    private Location lemmaFormLocation;

    @Column(name = "LEMMA_FORM_LANGUAGE")
    private Language lemmaFormLanguage;
}
