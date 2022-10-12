package se.uu.swedifying.model.api;

import io.swagger.v3.oas.annotations.media.Schema;
import se.uu.swedifying.model.util.ExistenceType;

public record CreateLocationRequest(
        ExistenceType realOrFictional
        , double longitude
        , double latitude
        , @Schema(defaultValue = "-1")
        long localityTypeId
        , CreateLocalityTypeRequest createLocalityTypeRequest) {

    public void validate() {
        if (localityTypeId() != -1 && createLocalityTypeRequest() != null) {
            throw new IllegalArgumentException(
                    String.format(
                            "Both location localityTypeId (%d) and createLocalityTypeRequest (%s) may not be set"
                            , localityTypeId
                            , createLocalityTypeRequest));
        }
    }
}
