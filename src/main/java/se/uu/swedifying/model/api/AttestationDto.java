package se.uu.swedifying.model.api;

import lombok.Builder;
import se.uu.swedifying.model.entity.AttestationVariantForm;

import java.util.Set;

@Builder
public record AttestationDto(
  long attestationId
  , String originalForm
  , String notes
  , boolean adaptedToSwedish
  , String determinationClause
  , String mainClauseInPhrase
  , String simpleRootMorpheme
  , String diversionBase
  , String mainClauseInSms
  , LocationDto location
  , String variantForm
  , String lemmaForm
  , String adaptationType
  , Set<String> attestationPrepositions
  , String morphologicalNameType
  , String etymology) {
}
