package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import se.uu.swedifying.model.entity.LocalityType;
import se.uu.swedifying.model.projection.AttestationView;
import se.uu.swedifying.model.projection.LocalityTypeView;

import java.util.List;

@RepositoryRestResource(excerptProjection = LocalityTypeView.class)
public interface LocalityTypeRepository extends CrudRepository<LocalityType, Long> {
  @Override
  List<LocalityType> findAll();

  List<LocalityType> findByLocalityTypeNameContains(String filter);

  List<LocalityType> findByLocalityTypeNameStartsWith(String filter);

  List<LocalityType> findByLocalityTypeNameEndsWith(String filter);

  LocalityType findByLocalityTypeName(String name);
}
