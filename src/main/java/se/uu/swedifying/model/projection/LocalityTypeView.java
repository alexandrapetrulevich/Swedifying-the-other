package se.uu.swedifying.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.LocalityType;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.LocalityType} entity
 */
@Projection(types = {LocalityType.class})
public interface LocalityTypeView {
  @Value("#{target.localityTypeId}")
  Long getLocalityTypeId();

  String getLocalityTypeName();
}