package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Location;

import java.util.List;

public interface LocationRepository extends CrudRepository<Location, Long> {
  @Override
  List<Location> findAll();

  Location findByModernLookupForm(String modernLookupForm);
}
