package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.Location;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.Location} entity
 */
@Projection(types = {Location.class})
public interface LocationView {
  Long getLocationId();

  double getLongitude();

  double getLatitude();

  String getModernLookupForm();

  SubRegionView getDistrictOrParish();

  LocalityTypeView getLocalityType();
}