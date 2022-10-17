package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.AdaptationType;

public interface AdaptationTypeRepository extends CrudRepository<AdaptationType, Long> {
}
