package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Attestation;
import se.uu.swedifying.model.entity.SourceFinding;

import java.util.List;

public interface SourceFindingRepository extends CrudRepository<SourceFinding, Long> {
  @Override
  List<SourceFinding> findAll();
}