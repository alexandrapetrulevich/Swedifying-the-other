package se.uu.swedifying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.uu.swedifying.model.api.AttestationDto;
import se.uu.swedifying.model.api.CreateAttestationRequest;
import se.uu.swedifying.model.api.LocationDto;
import se.uu.swedifying.model.entity.Attestation;
import se.uu.swedifying.repository.AttestationRepository;
import se.uu.swedifying.service.AttestationService;
import se.uu.swedifying.service.LocationService;

import java.util.List;

@Service
class AttestationServiceImpl implements AttestationService {

    private final AttestationRepository attestationRepository;
    private final LocationService locationService;

    @Autowired
    AttestationServiceImpl(
            AttestationRepository attestationRepository
            , LocationService locationService) {
        this.attestationRepository = attestationRepository;
        this.locationService = locationService;
    }


    @Override
    public AttestationDto createAttestation(CreateAttestationRequest createAttestationRequest) {
        createAttestationRequest.validate();
        LocationDto locationDto = handleLocation(createAttestationRequest);
        Attestation attestation = Attestation
                .builder()
                .originalForm(createAttestationRequest.originalForm())
                .location(locationService.locationDtoToLocation(locationDto))
                .build();
        return attestationToAttestationDto(attestationRepository.save(attestation));
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

    private AttestationDto attestationToAttestationDto(Attestation attestation) {
        return new AttestationDto(
                attestation.getAttestationId()
                , attestation.getOriginalForm()
                , locationService.locationToLocationDto(attestation.getLocation()));
    }

    @Override
    public List<AttestationDto> getAllAttestations() {
        return attestationRepository
                .findAll()
                .stream()
                .map(attestation -> attestationToAttestationDto(attestation))
                .toList();
    }

    @Override
    public AttestationDto getAttestationById(long id) {
        return attestationToAttestationDto(attestationRepository.findById(id).orElseThrow());
    }
}
