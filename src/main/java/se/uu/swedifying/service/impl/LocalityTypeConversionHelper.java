package se.uu.swedifying.service.impl;

import se.uu.swedifying.model.api.CreateLocalityTypeRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.model.entity.LocalityType;

class LocalityTypeConversionHelper {

  private LocalityTypeConversionHelper() {
  }

  static LocalityType createLocalityTypeRequestToLocalityType(CreateLocalityTypeRequest createLocalityTypeRequest) {
    return new LocalityType(createLocalityTypeRequest.localityTypeName());
  }

  static LocalityTypeDto localityTypeToLocalityTypeDto(LocalityType localityType) {
    if (localityType == null) return null;
    return new LocalityTypeDto(localityType.getLocalityTypeId(), localityType.getLocalityTypeName());
  }

  static LocalityType localityTypeDtoToLocalityType(LocalityTypeDto localityTypeDto) {
    if (localityTypeDto == null) return null;
    return new LocalityType(localityTypeDto.localityTypeId(), localityTypeDto.localityTypeName());
  }
}
