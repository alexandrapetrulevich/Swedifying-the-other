package se.uu.swedifying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.uu.swedifying.model.api.CreateLocationRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.model.api.LocationDto;
import se.uu.swedifying.model.entity.Location;
import se.uu.swedifying.repository.LocationRepository;
import se.uu.swedifying.service.LocalityTypeService;
import se.uu.swedifying.service.LocationService;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

  private final LocationRepository locationRepository;
  private final LocalityTypeService localityTypeService;

  @Autowired
  LocationServiceImpl(LocationRepository locationRepository, LocalityTypeService localityTypeService) {
    this.locationRepository = locationRepository;
    this.localityTypeService = localityTypeService;
  }

  @Override
  public LocationDto createLocation(CreateLocationRequest createLocationRequest) {
    createLocationRequest.validate();
    LocalityTypeDto locationTypeDto = handleLocalityType(createLocationRequest);
    Location location = LocationConversionHelper.createLocationRequestToLocation(
      createLocationRequest, locationTypeDto);
    return LocationConversionHelper.locationToLocationDto(locationRepository.save(location));
  }

  private LocalityTypeDto handleLocalityType(CreateLocationRequest createLocationRequest) {
    if (createLocationRequest.localityTypeId() != null) {
      return localityTypeService
        .getLocalityTypeById(createLocationRequest.localityTypeId());
    } else {
      return createLocationRequest.createLocalityTypeRequest() != null ?
        localityTypeService
          .createLocalityType(createLocationRequest.createLocalityTypeRequest())
        : null;
    }
  }

  @Override
  public LocationDto getLocationById(long id) {
    return LocationConversionHelper.locationToLocationDto(locationRepository.findById(id).orElseThrow());
  }

  @Override
  public List<LocationDto> getAllLocations() {
    return locationRepository
      .findAll()
      .stream()
      .map(LocationConversionHelper::locationToLocationDto)
      .toList();
  }
}
