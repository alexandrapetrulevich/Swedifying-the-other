package se.uu.swedifying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.uu.swedifying.model.api.AttestationDto;
import se.uu.swedifying.model.api.CreateAttestationRequest;
import se.uu.swedifying.model.api.LocationDto;
import se.uu.swedifying.model.entity.Attestation;
import se.uu.swedifying.model.entity.Etymology;
import se.uu.swedifying.model.entity.MorphologicalNameType;
import se.uu.swedifying.repository.AttestationRepository;
import se.uu.swedifying.repository.EtymologyRepository;
import se.uu.swedifying.repository.MorphologicalNameTypeRepository;
import se.uu.swedifying.service.AttestationService;
import se.uu.swedifying.service.LocationService;

import java.util.List;

@Service
class AttestationServiceImpl implements AttestationService {

  private final AttestationRepository attestationRepository;
  private final LocationService locationService;
  private final MorphologicalNameTypeRepository morphologicalNameTypeRepository;
  private final EtymologyRepository etymologyRepository;

  @Autowired
  AttestationServiceImpl(
    AttestationRepository attestationRepository
    , LocationService locationService
    , MorphologicalNameTypeRepository morphologicalNameTypeRepository
    , EtymologyRepository etymologyRepository) {
    this.attestationRepository = attestationRepository;
    this.locationService = locationService;
    this.morphologicalNameTypeRepository = morphologicalNameTypeRepository;
    this.etymologyRepository = etymologyRepository;
  }

  @Override
  public AttestationDto createAttestation(CreateAttestationRequest createAttestationRequest) {
    createAttestationRequest.validate();
    LocationDto locationDto = handleLocation(createAttestationRequest);
    Attestation attestation = AttestationConversionHelper
      .createAttestationRequestToAttestation(
        createAttestationRequest
        , locationDto);
    return AttestationConversionHelper
      .attestationToAttestationDto(attestationRepository.save(attestation));
  }

  private LocationDto handleLocation(CreateAttestationRequest createAttestationRequest) {
    if (createAttestationRequest.locationId() != -1) {
      return locationService
        .getLocationById(createAttestationRequest.locationId());
    } else {
      return createAttestationRequest.createLocationRequest() != null ?
        locationService.createLocation(createAttestationRequest.createLocationRequest())
        : null;
    }
  }

  @Override
  public List<AttestationDto> getAllAttestations() {
    return attestationRepository
      .findAll()
      .stream()
      .map(AttestationConversionHelper::attestationToAttestationDto)
      .toList();
  }

  @Override
  public AttestationDto getAttestationById(long id) {
    return AttestationConversionHelper
      .attestationToAttestationDto(attestationRepository.findById(id).orElseThrow());
  }

  @Override
  public List<AttestationDto> getAllFiltered(String morphologicalNameTypeFilter, String etymologyFilter) {
    List<MorphologicalNameType> morphologicalNameTypes = morphologicalNameTypeRepository
      .findByNameContains(morphologicalNameTypeFilter);
    List<Etymology> etymologies = etymologyRepository
      .findByNameContains(etymologyFilter);
    return attestationRepository.findByMorphologicalNameTypeInAndEtymologyIn(
      morphologicalNameTypes
      , etymologies).stream().map(AttestationConversionHelper::attestationToAttestationDto).toList();
  }
}
