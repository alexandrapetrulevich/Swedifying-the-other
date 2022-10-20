package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.MapSignature;

public interface MapSignatureRepository extends CrudRepository<MapSignature, Long> {
}