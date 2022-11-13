package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.Parish;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.Parish} entity
 */
@Projection(types = {Parish.class})
public interface ParishView {
  Long getSubRegionId();

  String getName();

  RegionView getBelongsToRegion();

  PrecinctView getBelongsToPrecinct();
}