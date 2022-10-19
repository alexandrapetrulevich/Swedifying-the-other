package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Region;

public interface RegionRepository extends CrudRepository<Region, Long> {
  Region findByRegionName(String regionName);
}