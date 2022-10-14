package se.uu.swedifying.service.impl;

import org.springframework.lang.Nullable;
import se.uu.swedifying.model.api.AttestationDto;
import se.uu.swedifying.model.api.CreateAttestationRequest;
import se.uu.swedifying.model.api.LocationDto;
import se.uu.swedifying.model.entity.Attestation;

import javax.validation.constraints.NotNull;
import java.util.Objects;

class AttestationConversionHelper {

  private AttestationConversionHelper() {
  }

  static Attestation createAttestationRequestToAttestation(
    @NotNull CreateAttestationRequest createAttestationRequest
    , @Nullable LocationDto locationDto) {
    Objects.requireNonNull(createAttestationRequest);
    return Attestation
      .builder()
      .originalForm(createAttestationRequest.originalForm())
      .location(LocationConversionHelper.locationDtoToLocation(locationDto))
      .build();
  }

  static AttestationDto attestationToAttestationDto(@NotNull Attestation attestation) {
    Objects.requireNonNull(attestation);
    return new AttestationDto(
      attestation.getAttestationId()
      , attestation.getOriginalForm()
      , LocationConversionHelper.locationToLocationDto(attestation.getLocation()));
  }
}
