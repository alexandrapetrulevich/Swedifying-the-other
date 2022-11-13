package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Region;

import java.util.List;

public interface RegionRepository extends CrudRepository<Region, Long> {
  Region findByRegionName(String regionName);
  List<Region> findByRegionNameContains(String regionNameFilter);
}