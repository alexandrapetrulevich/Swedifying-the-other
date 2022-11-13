package se.uu.swedifying.api.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.uu.swedifying.model.api.CreateSourceFindingRequest;
import se.uu.swedifying.model.entity.SourceFinding;
import se.uu.swedifying.service.SourceFindingService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sourcesFindings")
public class SourceFindingsResources {
    private final SourceFindingService sourceFindingService;

    @Autowired
    SourceFindingsResources(SourceFindingService sourceFindingService) {
        this.sourceFindingService = sourceFindingService;
    }

    @PostMapping
    public ResponseEntity<SourceFinding> createSourceFinding(
      @RequestBody CreateSourceFindingRequest createSourceFindingRequest) {
        SourceFinding sourceFinding = sourceFindingService.createSourceFinding(createSourceFindingRequest);
        return ResponseEntity
          .created(URI.create("/api/v1/sourcesFindings/" + sourceFinding.getSourceFindingId()))
          .body(sourceFinding);
    }

    @GetMapping
    public ResponseEntity<List<SourceFinding>> getAllSourceFindings() {
        return ResponseEntity.ok(sourceFindingService.getAllSourceFindings());
    }

}
