package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.NormalizedForm;
import se.uu.swedifying.model.util.MorphologicalNameType;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.NormalizedForm} entity
 */
@Projection(types = {NormalizedForm.class})
public interface NormalizedFormView {
  Long getNormalizedFormId();

  String getNormalizedForm();

  MorphologicalNameType getMorphologicalNameType();

  boolean isMorphologicalNameTypeIsShaky();

  String getComparativeFormInformation();

  MorphologicalDataView getMorphologicalData();

  LanguageView getEtymology();

  LanguageView getMediatingLanguage();
}