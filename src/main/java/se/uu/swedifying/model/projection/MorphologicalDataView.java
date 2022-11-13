package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.util.MorphologicalData;

/**
 * A Projection for the {@link se.uu.swedifying.model.util.MorphologicalData} entity
 */
@Projection(types = {MorphologicalData.class})
public interface MorphologicalDataView {
  String getDeterminationClauseInPhrase();

  String getMainClauseInPhrase();

  String getSimpleRootMorpheme();

  String getDerivationBase();

  String getDerivationMorpheme();

  String getDeterminationClauseInComposition();

  String getJointMorphemeInComposition();

  String getMainClauseInComposition();
}