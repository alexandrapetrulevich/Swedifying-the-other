package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.LandSurveyor;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.LandSurveyor} entity
 */
@Projection(types = {LandSurveyor.class})
public interface LandSurveyorView {
  Long getLandSurveyorId();

  String getName();
}