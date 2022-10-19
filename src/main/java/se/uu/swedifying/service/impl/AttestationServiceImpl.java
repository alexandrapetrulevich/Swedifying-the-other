package se.uu.swedifying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.uu.swedifying.model.api.AttestationDto;
import se.uu.swedifying.model.api.CreateAttestationRequest;
import se.uu.swedifying.model.api.LocationDto;
import se.uu.swedifying.model.entity.*;
import se.uu.swedifying.model.util.MorphologicalNameType;
import se.uu.swedifying.repository.*;
import se.uu.swedifying.service.AttestationService;
import se.uu.swedifying.service.LocationService;

import java.util.List;

@Service
class AttestationServiceImpl implements AttestationService {

  private final AttestationRepository attestationRepository;

  private final AttestationVariantFormRepository attestationVariantFormRepository;
  private final AttestationNormalizedFormRepository attestationNormalizedFormRepository;

  private final LanguageRepository languageRepository;
  private final LocationService locationService;

  @Autowired
  AttestationServiceImpl(
    AttestationRepository attestationRepository
    , LocationService locationService
    , AttestationVariantFormRepository attestationVariantFormRepository
    , AttestationNormalizedFormRepository attestationNormalizedFormRepository
    , LanguageRepository languageRepository) {
    this.attestationRepository = attestationRepository;
    this.locationService = locationService;
    this.attestationVariantFormRepository = attestationVariantFormRepository;
    this.attestationNormalizedFormRepository = attestationNormalizedFormRepository;
    this.languageRepository = languageRepository;
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
    MorphologicalNameType morphologicalNameType =
      morphologicalNameTypeFilter != null ?
        MorphologicalNameType.valueOf(morphologicalNameTypeFilter)
        : null;
    List<Language> etymologies = languageRepository.findByLanguageNameContains(etymologyFilter);
    List<AttestationNormalizedForm> normalizedForms = attestationNormalizedFormRepository
      .findByMorphologicalNameTypeAndEtymologyIn(morphologicalNameType, etymologies);
    List<AttestationVariantForm> variantForms = attestationVariantFormRepository
      .findByNormalizedFormIn(normalizedForms);
    return attestationRepository
      .findByVariantFormIn(variantForms)
      .stream()
      .map(AttestationConversionHelper::attestationToAttestationDto).toList();
  }
}
