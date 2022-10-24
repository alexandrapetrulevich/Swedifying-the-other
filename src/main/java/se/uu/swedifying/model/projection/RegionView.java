package se.uu.swedifying.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.Region;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.Region} entity
 */
@Projection(types = {Region.class})
public interface RegionView {
  @Value("#{target.regionId}")
  Long getRegionId();

  String getRegionName();
}