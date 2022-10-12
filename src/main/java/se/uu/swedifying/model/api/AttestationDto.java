package se.uu.swedifying.model.api;

public record AttestationDto(
        long attestationId
        , String originalForm
        , LocationDto location) {
}
