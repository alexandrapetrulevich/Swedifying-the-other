package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.SubRegion;

public interface SubRegionRepository extends CrudRepository<SubRegion, Long> {
  SubRegion findByName(String name);
}