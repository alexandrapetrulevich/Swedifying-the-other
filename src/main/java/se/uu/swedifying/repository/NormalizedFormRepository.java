package se.uu.swedifying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import se.uu.swedifying.model.entity.NormalizedForm;
import se.uu.swedifying.model.entity.Language;
import se.uu.swedifying.model.util.MorphologicalNameType;

import java.util.List;

public interface NormalizedFormRepository extends PagingAndSortingRepository<NormalizedForm, Long> {
  Page<NormalizedForm> findByMorphologicalNameTypeAndEtymologyIn(
    MorphologicalNameType morphologicalNameTypes
    , List<Language> etymologies
    , Pageable pageable);

  NormalizedForm findByNormalizedForm(String normalizedForm);

  Page<NormalizedForm> findByNormalizedFormContains(String normalizedFormFilter, Pageable pageable);
}
