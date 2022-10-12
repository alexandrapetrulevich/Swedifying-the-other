package se.uu.swedifying.service;

import se.uu.swedifying.model.api.CreateLocationRequest;
import se.uu.swedifying.model.api.LocationDto;
import se.uu.swedifying.model.entity.Location;

import java.util.List;

public interface LocationService {
    LocationDto createLocation(CreateLocationRequest createLocationRequest);
    LocationDto getLocationById(long id);

    LocationDto locationToLocationDto(Location location);
    Location locationDtoToLocation(LocationDto locationDto);

    List<LocationDto> getAllLocations();
}
