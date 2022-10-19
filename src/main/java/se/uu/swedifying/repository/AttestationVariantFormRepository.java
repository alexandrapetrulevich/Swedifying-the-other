package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.AttestationNormalizedForm;
import se.uu.swedifying.model.entity.AttestationVariantForm;

import java.util.List;

public interface AttestationVariantFormRepository extends CrudRepository<AttestationVariantForm, Long> {
  @Override
  List<AttestationVariantForm> findAll();
  List<AttestationVariantForm> findByNormalizedFormIn(List<AttestationNormalizedForm> normalizedForms);

  AttestationVariantForm findByVariantForm(String variantForm);
}
