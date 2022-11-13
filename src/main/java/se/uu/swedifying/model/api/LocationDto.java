package se.uu.swedifying.model.api;

import lombok.Builder;

@Builder
public record LocationDto(
        long locationId
        , double longitude
        , double latitude
        , String englishForm
        , LocalityTypeDto localityType) {
}
