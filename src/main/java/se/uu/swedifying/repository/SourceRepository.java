package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Source;

public interface SourceRepository extends CrudRepository<Source, Long> {
}