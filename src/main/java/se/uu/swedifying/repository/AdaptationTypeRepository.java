package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.uu.swedifying.model.entity.AdaptationType;
import se.uu.swedifying.model.entity.LocalityType;
import se.uu.swedifying.model.projection.AdaptationTypeView;
import se.uu.swedifying.model.projection.LocalityTypeView;

import java.util.List;

@RepositoryRestResource(excerptProjection = AdaptationTypeView.class)
public interface AdaptationTypeRepository extends CrudRepository<AdaptationType, Long> {
  AdaptationType findByName(String name);

  @Override
  List<AdaptationType> findAll();

  List<AdaptationType> findByNameContains(String filter);

  List<AdaptationType> findByNameStartsWith(String filter);

  List<AdaptationType> findByNameEndsWith(String filter);

}
