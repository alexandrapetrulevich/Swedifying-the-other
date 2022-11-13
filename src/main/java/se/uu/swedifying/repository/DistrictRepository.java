package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.uu.swedifying.model.entity.AdaptationType;
import se.uu.swedifying.model.entity.District;
import se.uu.swedifying.model.entity.Region;
import se.uu.swedifying.model.projection.AdaptationTypeView;
import se.uu.swedifying.model.projection.DistrictView;

import java.util.List;

@RepositoryRestResource(excerptProjection = DistrictView.class)
public interface DistrictRepository extends CrudRepository<District, Long> {
  List<District> findByNameContains(String nameFilter);
  List<District> findByBelongsToRegionRegionNameContains(String belongsToRegionsNameFilter);

  List<District> findByNameContainsAndBelongsToRegionRegionNameContains(
    String nameFilter
    , String belongsToRegionsNameFilter);

}
