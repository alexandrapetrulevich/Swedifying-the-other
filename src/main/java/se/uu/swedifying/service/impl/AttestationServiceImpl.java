package se.uu.swedifying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
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

  private final VariantFormRepository variantFormRepository;
  private final NormalizedFormRepository normalizedFormRepository;

  private final LanguageRepository languageRepository;
  private final LocationService locationService;

  @Autowired
  AttestationServiceImpl(
    AttestationRepository attestationRepository
    , LocationService locationService
    , VariantFormRepository variantFormRepository
    , NormalizedFormRepository normalizedFormRepository
    , LanguageRepository languageRepository) {
    this.attestationRepository = attestationRepository;
    this.locationService = locationService;
    this.variantFormRepository = variantFormRepository;
    this.normalizedFormRepository = normalizedFormRepository;
    this.languageRepository = languageRepository;
  }

  @Override
  public Attestation createAttestation(CreateAttestationRequest createAttestationRequest) {
    createAttestationRequest.validate();
    LocationDto locationDto = handleLocation(createAttestationRequest);
    Attestation attestation = AttestationConversionHelper
      .createAttestationRequestToAttestation(
        createAttestationRequest
        , locationDto);
    return attestationRepository.save(attestation);
    //return AttestationConversionHelper
    //  .attestationToAttestationDto(attestationRepository.save(attestation));
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
  public List<Attestation> getAllAttestations() {
    List<Attestation> allAttestations = attestationRepository.findAll(
      PageRequest.of(0, Integer.MAX_VALUE)).toList();
    return allAttestations;
      //.stream()
      //.map(AttestationConversionHelper::attestationToAttestationDto)
      //.toList();
  }

  @Override
  public Attestation getAttestationById(long id) {
    return attestationRepository.findById(id).orElseThrow();
    //return AttestationConversionHelper
    //  .attestationToAttestationDto(attestationRepository.findById(id).orElseThrow());
  }

  @Override
  public List<Attestation> getAllFiltered(
    String morphologicalNameTypeFilter
    , String etymologyFilter
    , int page
    , int pageSize) {
    MorphologicalNameType morphologicalNameType =
      morphologicalNameTypeFilter != null ?
        MorphologicalNameType.valueOf(morphologicalNameTypeFilter)
        : null;
    List<Language> etymologies = languageRepository.findByLanguageNameContains(etymologyFilter);
    Page<NormalizedForm> normalizedForms = normalizedFormRepository
      .findByMorphologicalNameTypeAndEtymologyIn(
        morphologicalNameType
        , etymologies
        , PageRequest.of(0, Integer.MAX_VALUE));
    Page<VariantForm> variantForms = variantFormRepository
      .findByNormalizedFormIn(
        normalizedForms.toList()
        , PageRequest.of(0, Integer.MAX_VALUE));
    return attestationRepository
      .findByVariantFormIn(variantForms.toList(), PageRequest.of(page, pageSize))
      .toList();
      //.stream()
      //.map(AttestationConversionHelper::attestationToAttestationDto).toList();
  }
}
