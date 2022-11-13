package se.uu.swedifying.model.api;

import lombok.Builder;

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
  , String morphologicalNameType
  , String etymology) {
}
