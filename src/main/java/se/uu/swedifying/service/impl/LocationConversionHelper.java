package se.uu.swedifying.service.impl;

import se.uu.swedifying.model.api.CreateLocationRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.model.api.LocationDto;
import se.uu.swedifying.model.entity.Location;

class LocationConversionHelper {
  private LocationConversionHelper() {
  }

  static Location createLocationRequestToLocation(
    CreateLocationRequest createLocationRequest
    , LocalityTypeDto locationTypeDto) {
    return Location
      .builder()
      .longitude(createLocationRequest.longitude())
      .latitude(createLocationRequest.latitude())
      .modernLookupForm(createLocationRequest.englishForm())
      .localityType(LocalityTypeConversionHelper.localityTypeDtoToLocalityType(locationTypeDto))
      .build();
  }

  static LocationDto locationToLocationDto(Location location) {
    if (location == null) return null;
    return new LocationDto(
      location.getLocationId()
      , location.getLongitude()
      , location.getLatitude()
      , location.getModernLookupForm()
      , LocalityTypeConversionHelper
      .localityTypeToLocalityTypeDto(location.getLocalityType()));
  }

  static Location locationDtoToLocation(LocationDto locationDto) {
    if (locationDto == null) return null;
    return Location
      .builder()
      .locationId(locationDto.locationId())
      .longitude(locationDto.longitude())
      .latitude(locationDto.latitude())
      .modernLookupForm(locationDto.englishForm())
      .localityType(LocalityTypeConversionHelper
        .localityTypeDtoToLocalityType(locationDto.localityType()))
      .build();
  }
}
