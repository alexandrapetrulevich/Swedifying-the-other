package se.uu.swedifying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import se.uu.swedifying.model.entity.NormalizedForm;
import se.uu.swedifying.model.entity.VariantForm;

import java.util.List;

public interface VariantFormRepository extends PagingAndSortingRepository<VariantForm, Long> {
  @Override
  Page<VariantForm> findAll(Pageable pageable);
  Page<VariantForm> findByNormalizedFormIn(List<NormalizedForm> normalizedForms, Pageable pageable);

  Page<VariantForm> findByVariantFormContains(String variantFormFilter, Pageable pageable);

  VariantForm findByVariantForm(String variantForm);
}
