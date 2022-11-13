package se.uu.swedifying.model.entity;

import lombok.*;
import se.uu.swedifying.model.util.MorphologicalData;
import se.uu.swedifying.model.util.MorphologicalNameType;

import javax.persistence.*;

@Entity
@Table(name = "NORMALIZED_FORM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class NormalizedForm {
  @Id
  @GeneratedValue
  @Column(name = "NORMALIZED_FORM_ID")
  private Long normalizedFormId;

  @Column(name = "NORMALIZED_FORM")
  private String normalizedForm;

  @Column(name = "MORPHOLOGICAL_NAME_TYPE")
  private MorphologicalNameType morphologicalNameType;

  @Column(name = "MORPHOLOGICAL_NAME_TYPE_IS_SHAKY")
  private boolean morphologicalNameTypeIsShaky;

  @Embedded
  private MorphologicalData morphologicalData;

  @Column(name = "COMPARATIVE_FORM_INFORMATION", columnDefinition = "TEXT")
  private String comparativeFormInformation;

  @ManyToOne
  @JoinColumn(name = "ETYMOLOGY_LANGUAGE_ID")
  private Language etymology;

  @ManyToOne
  @JoinColumn(name = "MEDIATING_LANGUAGE_ID")
  private Language mediatingLanguage;

}
