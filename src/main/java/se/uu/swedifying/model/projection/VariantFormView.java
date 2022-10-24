package se.uu.swedifying.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.VariantForm;
import se.uu.swedifying.model.util.IsAdaptedToSwedishType;

import java.util.List;


/**
 * A Projection for the {@link se.uu.swedifying.model.entity.VariantForm} entity
 */
@Projection(
  types = {VariantForm.class}
  , name = "variantFormView"
)
public interface VariantFormView {
  @Value("#{target.variantFormId}")
  Long getVariantFormId();

  String getVariantForm();

  IsAdaptedToSwedishType getIsAdaptedToSwedish();

  List<AdaptationTypeView> getAdaptationTypes();

  NormalizedFormView getNormalizedForm();
}
