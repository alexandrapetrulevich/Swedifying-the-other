package se.uu.swedifying.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.MapSource;
import se.uu.swedifying.model.entity.TextSource;

import java.time.LocalDate;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.MapSource} entity
 */
@Projection(types = {MapSource.class})
public interface MapSourceView {

  @Value("#{target.sourceId}")
  Long getSourceId();

  LocalDate getDating();

  int getMapSheet();

  LandSurveyorView getLandSurveyor();

  MapSignatureView getMapSignature();
}