package se.uu.swedifying.service.impl;

import se.uu.swedifying.model.api.AttestationDto;
import se.uu.swedifying.model.api.CreateAttestationRequest;
import se.uu.swedifying.model.api.LocationDto;
import se.uu.swedifying.model.entity.Attestation;
import se.uu.swedifying.model.entity.AttestationPreposition;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

class AttestationConversionHelper {

  private AttestationConversionHelper() {
  }

  static Attestation createAttestationRequestToAttestation(
    @NotNull CreateAttestationRequest createAttestationRequest
    , LocationDto locationDto) {
    Objects.requireNonNull(createAttestationRequest);
    return Attestation
      .builder()
      .originalForm(createAttestationRequest.originalForm())
      .location(LocationConversionHelper.locationDtoToLocation(locationDto))
      .build();
  }

  static AttestationDto attestationToAttestationDto(@NotNull Attestation attestation) {
    Objects.requireNonNull(attestation);
    return AttestationDto
      .builder()
      .attestationId(attestation.getAttestationId())
      .originalForm(attestation.getOriginalForm())
      .notes(attestation.getNotes())
      .adaptedToSwedish(attestation.isAdaptedToSwedish())
      .determinationClause(attestation.getDeterminationClause())
      .mainClauseInPhrase(attestation.getMainClauseInPhrase())
      .simpleRootMorpheme(attestation.getSimpleRootMorpheme())
      .diversionBase(attestation.getDiversionBase())
      .mainClauseInSms(attestation.getMainClauseInSms())
      .location(LocationConversionHelper.locationToLocationDto(attestation.getLocation()))
      .variantForm(attestation.getVariantForm() != null ? attestation.getVariantForm().getVariantFormName() : "")
      .lemmaForm(attestation.getLemmaForm() != null ? attestation.getLemmaForm().getLemmaFormName(): "")
      .attestationPrepositions(
        attestation.getAttestationPrepositions() != null ?
          attestation.getAttestationPrepositions().stream().map(AttestationPreposition::getPrepositionName).collect(Collectors.toSet())
          : Set.of())
      .morphologicalNameType(attestation.getMorphologicalNameType() != null ? attestation.getMorphologicalNameType().getName() : "")
      .etymology(attestation.getEtymology() != null ? attestation.getEtymology().getName() : "")
      .build();
  }
}
