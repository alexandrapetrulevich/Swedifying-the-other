package se.uu.swedifying.model.api;

import se.uu.swedifying.model.util.ExistenceType;

public record LocationDto(
        long locationId
        , ExistenceType realOrFictional
        , double longitude
        , double latitude
        , String englishForm
        , LocalityTypeDto localityType) {
}
