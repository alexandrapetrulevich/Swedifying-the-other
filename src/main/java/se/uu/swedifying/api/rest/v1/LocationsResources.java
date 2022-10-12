package se.uu.swedifying.api.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.uu.swedifying.model.api.CreateLocalityTypeRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.service.LocalityTypeService;

import java.net.URI;

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
}
