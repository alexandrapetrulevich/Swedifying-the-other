package se.uu.swedifying.model.api;

import lombok.Builder;
import se.uu.swedifying.model.util.ExistenceType;

@Builder
public record LocationDto(
        long locationId
        , ExistenceType realOrFictional
        , double longitude
        , double latitude
        , String englishForm
        , LocalityTypeDto localityType) {
}
