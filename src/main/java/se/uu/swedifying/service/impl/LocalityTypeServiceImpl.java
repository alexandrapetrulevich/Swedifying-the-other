package se.uu.swedifying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.uu.swedifying.model.api.CreateLocalityTypeRequest;
import se.uu.swedifying.model.api.LocalityTypeDto;
import se.uu.swedifying.model.entity.LocalityType;
import se.uu.swedifying.repository.LocalityTypeRepository;
import se.uu.swedifying.service.LocalityTypeService;

import java.util.List;

@Service
public class LocalityTypeServiceImpl implements LocalityTypeService {

    private final LocalityTypeRepository localityTypeRepository;

    @Autowired
    LocalityTypeServiceImpl(LocalityTypeRepository localityTypeRepository) {
        this.localityTypeRepository = localityTypeRepository;
    }

    @Override
    public LocalityTypeDto createLocalityType(CreateLocalityTypeRequest createLocalityTypeRequest) {
        return localityTypeToLocalityTypeDto(
                localityTypeRepository.save(new LocalityType(createLocalityTypeRequest.localityTypeName())));
    }

    @Override
    public LocalityTypeDto localityTypeToLocalityTypeDto(LocalityType localityType) {
        if (localityType == null) return null;
        return new LocalityTypeDto(localityType.getLocalityTypeId(), localityType.getLocalityTypeName());
    }

    @Override
    public LocalityType localityTypeDtoToLocalityType(LocalityTypeDto localityTypeDto) {
        if (localityTypeDto == null) return null;
        return new LocalityType(localityTypeDto.localityTypeId(), localityTypeDto.localityTypeName());
    }

    @Override
    public List<LocalityTypeDto> getAllLocalityTypes() {
        return localityTypeRepository
                .findAll()
                .stream()
                .map(localityType -> localityTypeToLocalityTypeDto(localityType))
                .toList();
    }

    @Override
    public LocalityTypeDto getLocalityTypeById(long id) {
        return localityTypeToLocalityTypeDto(localityTypeRepository.findById(id).orElseThrow());
    }
}
