package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Parish;

public interface ParishRepository extends CrudRepository<Parish, Long> {
}