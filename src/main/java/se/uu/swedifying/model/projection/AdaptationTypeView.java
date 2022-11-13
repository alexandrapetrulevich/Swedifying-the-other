package se.uu.swedifying.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.AdaptationType;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.AdaptationType} entity
 */
@Projection(types = {AdaptationType.class})
public interface AdaptationTypeView {
  @Value("#{target.adaptationTypeId}")
  Long getAdaptationTypeId();

  String getName();
}