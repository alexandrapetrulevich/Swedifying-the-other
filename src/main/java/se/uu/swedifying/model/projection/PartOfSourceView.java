package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.PartOfSource;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.PartOfSource} entity
 */
@Projection(types = {PartOfSource.class})
public interface PartOfSourceView {
  Long getPartOfSourceId();

  String getPartOfSourceName();
}