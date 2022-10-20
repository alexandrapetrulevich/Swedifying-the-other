package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.PartOfSource;

public interface PartOfSourceRepository extends CrudRepository<PartOfSource, Long> {
  PartOfSource findByPartOfSourceName(String name);
}