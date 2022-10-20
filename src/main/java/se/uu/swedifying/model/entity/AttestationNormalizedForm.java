package se.uu.swedifying.model.entity;

import lombok.*;
import se.uu.swedifying.model.util.MorphologicalData;
import se.uu.swedifying.model.util.MorphologicalNameType;

import javax.persistence.*;

@Entity
@Table(name = "ATTESTATION_NORMALIZED_FORM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class AttestationNormalizedForm {
  @Id
  @GeneratedValue
  @Column(name = "NORMALIZED_FORM_ID")
  private Long normalizedFormId;

  @Column(name = "NORMALIZED_FORM")
  private String normalizedForm;

  private MorphologicalNameType morphologicalNameType;
  private boolean morphologicalNameTypeIsShaky;
  @Embedded
  private MorphologicalData morphologicalData;

  private String comparativeFormInformation;

  @ManyToOne
  @JoinColumn(name = "ETYMOLOGY_LANGUAGE_ID")
  private Language etymology;

  @ManyToOne
  @JoinColumn(name = "MEDIATING_LANGUAGE_ID")
  private Language mediatingLanguage;

}
