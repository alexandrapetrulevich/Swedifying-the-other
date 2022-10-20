package se.uu.swedifying.api.rest.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.uu.swedifying.model.api.CreateMapSourceRequest;
import se.uu.swedifying.model.entity.Source;
import se.uu.swedifying.model.entity.TextSource;
import se.uu.swedifying.service.SourceService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sources")
public class SourcesResources {
  private final SourceService sourceService;

  public SourcesResources(SourceService sourceService) {
    this.sourceService = sourceService;
  }

  @PostMapping("/mapSources")
  public ResponseEntity<Source> createMapSource(@RequestBody CreateMapSourceRequest createMapSourceRequest) {
    Source source = sourceService.createSource(createMapSourceRequest);
    return ResponseEntity.created(URI.create("/api/v1/sources" + source.getSourceId())).body(source);
  }

  @PostMapping("/textSources")
  public ResponseEntity<Source> createMapSource(@RequestBody TextSource textSource) {
    return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
  }

  @GetMapping
  public ResponseEntity<List<Source>> getAllSources() {
    return ResponseEntity.ok(sourceService.getAllSources());
  }
}
