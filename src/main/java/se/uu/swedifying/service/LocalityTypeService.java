package se.uu.swedifying.service;

import se.uu.swedifying.model.api.CreateLocalityTypeRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.model.entity.LocalityType;

import java.util.List;

public interface LocalityTypeService {
  LocalityTypeDto createLocalityType(CreateLocalityTypeRequest createLocalityTypeRequest);

  LocalityTypeDto getLocalityTypeById(long id);

  List<LocalityTypeDto> getAllLocalityTypes();

  List<LocalityTypeDto> getFilteredLocalityTypes(String filterText);

  void deleteLocalityTypeById(long id);
}
