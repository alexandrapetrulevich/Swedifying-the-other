package se.uu.swedifying.api.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.uu.swedifying.model.api.CreateLocationRequest;
import se.uu.swedifying.model.api.LocationDto;
import se.uu.swedifying.model.entity.SourceFinding;
import se.uu.swedifying.repository.SourceFindingRepository;
import se.uu.swedifying.service.LocationService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sourceFindings")
public class SourceFindingsResources {
    private final SourceFindingRepository sourceFindingRepository;

    @Autowired
    SourceFindingsResources(SourceFindingRepository sourceFindingRepository) {
        this.sourceFindingRepository = sourceFindingRepository;
    }

    @GetMapping
    public ResponseEntity<List<SourceFinding>> getAllSourceFinsings() {
        return ResponseEntity.ok(sourceFindingRepository.findAll());
    }

}
