package se.uu.swedifying.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.Source;

import java.time.LocalDate;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.Source} entity
 */
@Projection(types = {Source.class})
public interface SourceView {

  @Value("#{target.getClass().getSimpleName()}")
  String getType();

  Long getSourceId();

  LocalDate getDating();

  LandSurveyorView getLandSurveyor();
}