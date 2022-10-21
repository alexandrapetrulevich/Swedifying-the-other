package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.District;

public interface DistrictRepository extends CrudRepository<District, Long> {
}
