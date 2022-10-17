package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Attestation;
import se.uu.swedifying.model.entity.Etymology;
import se.uu.swedifying.model.entity.LocalityType;
import se.uu.swedifying.model.entity.MorphologicalNameType;

import java.util.List;

public interface AttestationRepository extends CrudRepository<Attestation, Long> {
    @Override
    List<Attestation> findAll();

    List<Attestation> findByMorphologicalNameTypeInAndEtymologyIn(
      List<MorphologicalNameType> morphologicalNameTypes
      , List<Etymology> etymologies);
}
