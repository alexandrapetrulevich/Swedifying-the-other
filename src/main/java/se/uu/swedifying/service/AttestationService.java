package se.uu.swedifying.service;


import se.uu.swedifying.model.api.AttestationDto;
import se.uu.swedifying.model.api.CreateAttestationRequest;
import se.uu.swedifying.model.entity.Attestation;

import java.util.List;

public interface AttestationService {
  Attestation createAttestation(CreateAttestationRequest createAttestationRequest);

  List<Attestation> getAllAttestations();
  List<Attestation> getAllFiltered(
    String morphologicalNameTypeFilter
    , String etymologyFilter
    , int page
    , int pageSize);

  Attestation getAttestationById(long id);
}
