package se.uu.swedifying.service.impl;

import org.junit.jupiter.api.Test;
import se.uu.swedifying.model.api.CreateLocalityTypeRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.model.entity.LocalityType;

import static org.junit.jupiter.api.Assertions.*;

class LocalityTypeConversionHelperTest {

  @Test
  void testCreateLocalityTypeRequestToLocalityType() {
    String expectedLocalityTypeName = "locality type";
    CreateLocalityTypeRequest createLocalityTypeRequest = new CreateLocalityTypeRequest(
      expectedLocalityTypeName);
    LocalityType localityType = LocalityTypeConversionHelper
      .createLocalityTypeRequestToLocalityType(createLocalityTypeRequest);
    assertEquals(expectedLocalityTypeName, localityType.getLocalityTypeName());
    assertNull(localityType.getLocalityTypeId());
  }

  @Test
  void testCreateLocalityTypeRequestToLocalityTypeCreateLocalityTypeRequestIsNull() {
    assertThrows(
      NullPointerException.class
      , () ->
        LocalityTypeConversionHelper.createLocalityTypeRequestToLocalityType(null));
  }

  @Test
  void localityTypeToLocalityTypeDto() {
    long expectedLocalityTypeId = 1;
    String expectedLocalityTypeName = "locality type";
    LocalityType localityType = LocalityType
      .builder()
      .localityTypeId(expectedLocalityTypeId)
      .localityTypeName(expectedLocalityTypeName)
      .build();
    LocalityTypeDto localityTypeDto = LocalityTypeConversionHelper
      .localityTypeToLocalityTypeDto(localityType);
    assertEquals(localityType.getLocalityTypeId(), localityTypeDto.localityTypeId());
    assertEquals(localityType.getLocalityTypeName(), localityTypeDto.localityTypeName());
  }

  @Test
  void localityTypeToLocalityTypeDtoLocalityTypeNull() {
    assertNull(LocalityTypeConversionHelper
      .localityTypeToLocalityTypeDto(null));
  }

  @Test
  void localityTypeDtoToLocalityType() {
    long expectedLocalityTypeId = 1L;
    String expectedLocalityTypeName = "type name";
    LocalityTypeDto localityTypeDto = new LocalityTypeDto(expectedLocalityTypeId, expectedLocalityTypeName);
    LocalityType localityType = LocalityTypeConversionHelper
      .localityTypeDtoToLocalityType(localityTypeDto);
    assertEquals(expectedLocalityTypeId, localityType.getLocalityTypeId());
    assertEquals(expectedLocalityTypeName, localityType.getLocalityTypeName());
  }

  @Test
  void localityTypeDtoToLocalityTypeLocalityTypeDtoNull() {
    assertNull(LocalityTypeConversionHelper.localityTypeDtoToLocalityType(null));
  }
}