package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.Precinct;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.Precinct} entity
 */
@Projection(types = {Precinct.class})
public interface PrecinctView {
  Long getSubRegionId();

  String getName();

  RegionView getBelongsToRegion();
}