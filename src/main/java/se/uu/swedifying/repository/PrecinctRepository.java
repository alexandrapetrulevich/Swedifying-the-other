package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Precinct;

public interface PrecinctRepository extends CrudRepository<Precinct, Long> {
}