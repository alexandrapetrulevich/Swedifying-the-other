package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.SubRegion;
import se.uu.swedifying.model.entity.TextSource;

import java.time.LocalDate;

/**
 * A Projection for the {@link TextSource} entity
 */
@Projection(types = {TextSource.class})
public interface TextSourceView {
  Long getSourceId();

  LocalDate getDating();

  String getName();

  String getSubSection();

  int getPage();

  LandSurveyorView getLandSurveyor();
}