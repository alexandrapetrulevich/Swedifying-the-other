package se.uu.swedifying.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.uu.swedifying.model.entity.Attestation;
import se.uu.swedifying.model.entity.VariantForm;
import se.uu.swedifying.model.projection.AttestationView;

import java.util.List;

@RepositoryRestResource(excerptProjection = AttestationView.class)
public interface AttestationRepository extends PagingAndSortingRepository<Attestation, Long> {
    @Override
    Page<Attestation> findAll(Pageable pageable);

    Page<Attestation> findByVariantFormIn(
      List<VariantForm> variantForms, Pageable pageable);
}
