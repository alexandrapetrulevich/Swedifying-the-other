package se.uu.swedifying.service;

import se.uu.swedifying.model.api.CreateLocalityTypeRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.model.entity.LocalityType;

import java.util.List;

public interface LocalityTypeService {
    LocalityTypeDto createLocalityType(CreateLocalityTypeRequest createLocalityTypeRequest);
    LocalityTypeDto getLocalityTypeById(long id);

    LocalityTypeDto localityTypeToLocalityTypeDto(LocalityType localityType);
    LocalityType localityTypeDtoToLocalityType(LocalityTypeDto localityTypeDto);

    List<LocalityTypeDto> getAllLocalityTypes();
}
