package se.uu.swedifying.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.SubRegion;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.SubRegion} entity
 */
@Projection(types = {SubRegion.class})
public interface SubRegionView {
  Long getSubRegionId();

  @Value("#{target.getClass().getSimpleName()}")
  String getType();

  String getName();

  RegionView getBelongsToRegion();
}