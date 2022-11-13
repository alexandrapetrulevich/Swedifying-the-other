package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.NormalizedForm;
import se.uu.swedifying.model.entity.VariantForm;

import java.util.List;

public interface VariantFormRepository extends CrudRepository<VariantForm, Long> {
  @Override
  List<VariantForm> findAll();
  List<VariantForm> findByNormalizedFormIn(List<NormalizedForm> normalizedForms);

  VariantForm findByVariantForm(String variantForm);
}
