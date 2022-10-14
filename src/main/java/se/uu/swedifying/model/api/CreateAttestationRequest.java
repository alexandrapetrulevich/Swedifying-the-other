package se.uu.swedifying.model.api;

import io.swagger.v3.oas.annotations.media.Schema;

public record CreateAttestationRequest(
        String originalForm
        , Long locationId
        , CreateLocationRequest createLocationRequest) {

    public void validate() {
        if (locationId() != null && createLocationRequest() != null) {
            throw new IllegalArgumentException(
                    String.format(
                            "Both location locationId (%d) and createLocationRequest (%s) may not be set"
                            , locationId
                            , createLocationRequest));
        }
    }
}
