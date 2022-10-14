package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import se.uu.swedifying.model.util.Language;

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

    @Column(name = "LEMMA_FORM_LANGUAGE")
    private Language lemmaFormLanguage;

    @ManyToOne
    @JoinColumn(name = "LEMMA_FORM_LOCATION_ID")
    private Location lemmaFormLocation;

}
