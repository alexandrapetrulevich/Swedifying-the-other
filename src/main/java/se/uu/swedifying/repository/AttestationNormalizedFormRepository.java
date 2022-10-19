package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.AttestationNormalizedForm;
import se.uu.swedifying.model.entity.Language;
import se.uu.swedifying.model.util.MorphologicalNameType;

import java.util.List;

public interface AttestationNormalizedFormRepository extends CrudRepository<AttestationNormalizedForm, Long> {
  List<AttestationNormalizedForm> findByMorphologicalNameTypeAndEtymologyIn(
    MorphologicalNameType morphologicalNameTypes
    , List<Language> etymologies
  );

  AttestationNormalizedForm findByNormalizedForm(String normalizedForm);
}
