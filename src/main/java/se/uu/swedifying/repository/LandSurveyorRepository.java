package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.LandSurveyor;

import java.util.List;

public interface LandSurveyorRepository extends CrudRepository<LandSurveyor, Long> {
  LandSurveyor findByName(String name);

  List<LandSurveyor> findByNameContains(String nameFilter);
}