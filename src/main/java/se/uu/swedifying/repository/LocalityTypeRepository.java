package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.LocalityType;
import se.uu.swedifying.model.entity.Location;

import java.util.List;

public interface LocalityTypeRepository extends CrudRepository<LocalityType, Long> {
    @Override
    List<LocalityType> findAll();
}
