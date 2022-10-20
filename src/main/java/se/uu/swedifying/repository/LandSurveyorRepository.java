package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.LandSurveyor;

public interface LandSurveyorRepository extends CrudRepository<LandSurveyor, Long> {
  LandSurveyor findByName(String name);
}