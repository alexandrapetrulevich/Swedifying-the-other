package se.uu.swedifying.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.Source;
import se.uu.swedifying.model.entity.SourceFinding;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.SourceFinding} entity
 */
@Projection(types = {SourceFinding.class})
public interface SourceFindingView {
  Long getSourceFindingId();

  SourceView getSource();

  PartOfSourceView getPartOfSource();
}