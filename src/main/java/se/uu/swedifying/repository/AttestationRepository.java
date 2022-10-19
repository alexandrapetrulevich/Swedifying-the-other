package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Attestation;
import se.uu.swedifying.model.entity.AttestationVariantForm;

import java.util.List;

public interface AttestationRepository extends CrudRepository<Attestation, Long> {
    @Override
    List<Attestation> findAll();

    List<Attestation> findByVariantFormIn(
      List<AttestationVariantForm> etymologies);
}
