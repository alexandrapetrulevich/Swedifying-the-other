package se.uu.swedifying.model.api;

import se.uu.swedifying.model.util.ExistenceType;

public record CreateLocationRequest(
        ExistenceType realOrFictional
        , double longitude
        , double latitude
        , String englishForm
        , Long localityTypeId
        , CreateLocalityTypeRequest createLocalityTypeRequest) {

    public void validate() {
        if (localityTypeId() != null && createLocalityTypeRequest() != null) {
            throw new IllegalArgumentException(
                    String.format(
                            "Both location localityTypeId (%d) and createLocalityTypeRequest (%s) may not be set"
                            , localityTypeId
                            , createLocalityTypeRequest));
        }
    }
}
