package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.LocalityType;
import se.uu.swedifying.model.entity.MorphologicalNameType;

import java.util.List;

public interface MorphologicalNameTypeRepository extends CrudRepository<MorphologicalNameType, Long> {
  MorphologicalNameType findByName(String name);
  List<MorphologicalNameType> findByNameContains(String filter);
}
