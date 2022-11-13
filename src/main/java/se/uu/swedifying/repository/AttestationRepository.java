package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.uu.swedifying.model.entity.Attestation;
import se.uu.swedifying.model.entity.VariantForm;
import se.uu.swedifying.model.projection.AttestationView;

import java.util.List;

@RepositoryRestResource(excerptProjection = AttestationView.class)
public interface AttestationRepository extends CrudRepository<Attestation, Long> {
    @Override
    List<Attestation> findAll();

    List<Attestation> findByVariantFormIn(
      List<VariantForm> etymologies);
}
