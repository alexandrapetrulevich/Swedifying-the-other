package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Etymology;
import se.uu.swedifying.model.entity.MorphologicalNameType;

import java.util.List;

public interface EtymologyRepository extends CrudRepository<Etymology, Long> {
  Etymology findByName(String name);
  List<Etymology> findByNameContains(String filter);
}
