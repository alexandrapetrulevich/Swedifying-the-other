package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Source;

import java.util.List;

public interface SourceRepository extends CrudRepository<Source, Long> {
  @Override
  List<Source> findAll();
}