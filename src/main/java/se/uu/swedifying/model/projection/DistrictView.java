package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.District;
import se.uu.swedifying.model.entity.LandSurveyor;
import se.uu.swedifying.model.projection.RegionView;

/**
 * A Projection for the {@link District} entity
 */
@Projection(types = {District.class})
public interface DistrictView {
  Long getSubRegionId();

  String getName();

  RegionView getBelongsToRegion();
}