package se.uu.swedifying.api.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.uu.swedifying.model.api.CreateLocalityTypeRequest;
import se.uu.swedifying.model.api.CreateLocationRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.model.api.LocationDto;
import se.uu.swedifying.service.LocalityTypeService;
import se.uu.swedifying.service.LocationService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationsResources {
    private final LocationService locationService;

    @Autowired
    LocationsResources(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<LocationDto> createLocation(
            @RequestBody CreateLocationRequest createLocationRequest) {
        LocationDto locationDto = locationService.createLocation(createLocationRequest);
        return ResponseEntity
                .created(URI.create("/api/v1/location/" + locationDto.locationId()))
                .body(locationDto);
    }

    @GetMapping
    public ResponseEntity<List<LocationDto>> getAllLocations() {
        return ResponseEntity.ok(locationService.getAllLocations());
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<LocationDto> getLocationById(@PathVariable long locationId) {
        return ResponseEntity.ok(locationService.getLocationById(locationId));
    }

}
