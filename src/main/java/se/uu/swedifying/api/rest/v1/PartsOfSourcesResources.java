package se.uu.swedifying.api.rest.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.uu.swedifying.model.entity.PartOfSource;
import se.uu.swedifying.model.entity.Source;
import se.uu.swedifying.repository.PartOfSourceRepository;
import se.uu.swedifying.repository.SourceRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partsOfSources")
public class PartsOfSourcesResources {
  private final PartOfSourceRepository partOfSourceRepository;

  public PartsOfSourcesResources(PartOfSourceRepository partOfSourceRepository) {
    this.partOfSourceRepository = partOfSourceRepository;
  }

  @GetMapping
  public ResponseEntity<List<PartOfSource>> getAllPartsOfSources() {
    return ResponseEntity.ok(partOfSourceRepository.findAll());
  }
}
