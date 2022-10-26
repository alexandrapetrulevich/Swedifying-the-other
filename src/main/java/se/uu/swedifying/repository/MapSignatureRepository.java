package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.MapSignature;

import java.util.List;

public interface MapSignatureRepository extends CrudRepository<MapSignature, Long> {
  List<MapSignature> findByMapSignatureContains(String mapSignatureFilter);
}