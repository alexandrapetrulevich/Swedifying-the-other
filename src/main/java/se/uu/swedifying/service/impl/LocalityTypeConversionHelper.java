package se.uu.swedifying.service.impl;

import se.uu.swedifying.model.api.CreateLocalityTypeRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.model.entity.LocalityType;

import javax.validation.constraints.NotNull;
import java.util.Objects;

class LocalityTypeConversionHelper {

  private LocalityTypeConversionHelper() {
  }

  static LocalityType createLocalityTypeRequestToLocalityType(
    @NotNull CreateLocalityTypeRequest createLocalityTypeRequest) {
    Objects.requireNonNull(createLocalityTypeRequest);
    return LocalityType.builder().localityTypeName(createLocalityTypeRequest.localityTypeName()).build();
  }

  static LocalityTypeDto localityTypeToLocalityTypeDto(LocalityType localityType) {
    if (localityType == null) return null;
    return new LocalityTypeDto(localityType.getLocalityTypeId(), localityType.getLocalityTypeName());
  }

  static LocalityType localityTypeDtoToLocalityType(LocalityTypeDto localityTypeDto) {
    if (localityTypeDto == null) return null;
    return LocalityType
      .builder()
      .localityTypeId(localityTypeDto.localityTypeId())
      .localityTypeName(localityTypeDto.localityTypeName())
      .build();
  }
}
