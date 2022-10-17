package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import se.uu.swedifying.model.util.Language;

import javax.persistence.*;

@Entity
@Table(name = "ATTESTATION_PREPOSITION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class AttestationPreposition {
    @Id
    @GeneratedValue
    @Column(name = "PREPOSITION_ID")
    private Long prepositionId;

    @Column(name = "PREPOSITION_NAME")
    private String prepositionName;

    @Column(name = "PREPOSITION_LANGUAGE")
    private Language prepositionLanguage;
}
