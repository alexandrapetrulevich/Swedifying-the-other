package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.PartOfSource;
import se.uu.swedifying.model.entity.Source;

import java.util.List;

public interface PartOfSourceRepository extends CrudRepository<PartOfSource, Long> {
  PartOfSource findByPartOfSourceName(String name);
  @Override
  List<PartOfSource> findAll();

  List<PartOfSource> findByPartOfSourceNameContains(String partOfSourceNameFilter);
}