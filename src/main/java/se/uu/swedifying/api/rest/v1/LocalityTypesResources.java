package se.uu.swedifying.api.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.uu.swedifying.model.api.CreateLocalityTypeRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.service.LocalityTypeService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/localityTypes")
public class LocalityTypesResources {
    private final LocalityTypeService localityTypeService;

    @Autowired
    LocalityTypesResources(LocalityTypeService localityTypeService) {
        this.localityTypeService = localityTypeService;
    }

    @PostMapping
    public ResponseEntity<LocalityTypeDto> createLocalityType(
            @RequestBody CreateLocalityTypeRequest createLocalityTypeRequest) {
        LocalityTypeDto localityTypeDto = localityTypeService.createLocalityType(createLocalityTypeRequest);
        return ResponseEntity
                .created(URI.create("/api/v1/localityTypes/" + localityTypeDto.localityTypeId()))
                .body(localityTypeDto);
    }

    @GetMapping
    public ResponseEntity<List<LocalityTypeDto>> getAllLocalityTypes(
            @RequestParam(defaultValue = "") String filterText) {
        if (!filterText.isBlank())
            return ResponseEntity.ok(localityTypeService.getFilteredLocalityTypes(filterText));
        else
            return ResponseEntity.ok(localityTypeService.getAllLocalityTypes());
    }

    @GetMapping("/{localityTypeId}")
    public ResponseEntity<LocalityTypeDto> getLocalityTypeById(@PathVariable long localityTypeId) {
        return ResponseEntity.ok(localityTypeService.getLocalityTypeById(localityTypeId));
    }

    @DeleteMapping("/{localityTypeId}")
    public ResponseEntity<Void> deleteLocalityType(@PathVariable long localityTypeId) {
        localityTypeService.deleteLocalityTypeById(localityTypeId);
        return ResponseEntity.noContent().build();
    }

}
