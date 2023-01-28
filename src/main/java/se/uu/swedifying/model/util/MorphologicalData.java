package se.uu.swedifying.model.util;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * Data associated with a normalized form.
 * Different parameters apply depending on
 * the current {@link MorphologicalNameType}
 *
 * @param determinationClauseInPhrase      Applies to PHRASE
 * @param mainClauseInPhrase               Applies to PHRASE
 * @param simpleRootMorpheme               Applies to SIMPLE
 * @param derivationBase                   Applies to DERIVATION
 * @param derivationMorpheme               Applies to DERIVATION
 * @param determinationClauseInComposition Applies to COMPOSITION
 * @param jointMorphemeInComposition       Applies to COMPOSITION
 * @param mainClauseInComposition          Applies to COMPOSITION
 */
@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder
public class MorphologicalData {
  // Applies to PHRASE
  private String determinationClauseInPhrase;
  // Applies to PHRASE
  private String mainClauseInPhrase;
  // Applies to SIMPLE
  private String simpleRootMorpheme;
  // Applies to DERIVATION
  private String derivationBase;
  // Applies to DERIVATION
  private String derivationMorpheme;
  // Applies to COMPOSITION
  private String determinationClauseInComposition;
  // Applies to COMPOSITION
  private String jointMorphemeInComposition;
  // Applies to COMPOSITION
  private String mainClauseInComposition;
}
