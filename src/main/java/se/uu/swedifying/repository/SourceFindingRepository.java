package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.SourceFinding;

public interface SourceFindingRepository extends CrudRepository<SourceFinding, Long> {
}