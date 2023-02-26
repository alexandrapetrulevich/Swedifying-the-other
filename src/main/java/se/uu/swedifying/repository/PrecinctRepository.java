package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Precinct;
import se.uu.swedifying.model.entity.Region;

import java.util.List;

public interface PrecinctRepository extends CrudRepository<Precinct, Long> {
  List<Precinct> findByBelongsToRegionRegionId(Long regionId);
}