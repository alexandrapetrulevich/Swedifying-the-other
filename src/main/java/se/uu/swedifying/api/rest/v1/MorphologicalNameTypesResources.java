package se.uu.swedifying.api.rest.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.uu.swedifying.model.util.MorphologicalNameType;

import java.util.EnumSet;
import java.util.Set;

@RestController
@RequestMapping("/api/morphologicalNameTypes")
public class MorphologicalNameTypesResources {

  @GetMapping
  public ResponseEntity<Set<MorphologicalNameType>> getAllMorphologicalNameTypes() {
    return ResponseEntity.ok(EnumSet.allOf(MorphologicalNameType.class));
  }
}
