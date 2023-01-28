package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.NormalizedForm;
import se.uu.swedifying.model.entity.Language;
import se.uu.swedifying.model.util.MorphologicalNameType;

import java.util.List;

public interface NormalizedFormRepository extends CrudRepository<NormalizedForm, Long> {
  List<NormalizedForm> findByMorphologicalNameTypeAndEtymologyIn(
    MorphologicalNameType morphologicalNameTypes
    , List<Language> etymologies);

  NormalizedForm findByNormalizedForm(String normalizedForm);

  List<NormalizedForm> findByNormalizedFormContains(String normalizedFormFilter);
}
