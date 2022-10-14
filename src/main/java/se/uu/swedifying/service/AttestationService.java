package se.uu.swedifying.service;


import se.uu.swedifying.model.api.AttestationDto;
import se.uu.swedifying.model.api.CreateAttestationRequest;

import java.util.List;

public interface AttestationService {
  AttestationDto createAttestation(CreateAttestationRequest createAttestationRequest);

  List<AttestationDto> getAllAttestations();

  AttestationDto getAttestationById(long id);
}
