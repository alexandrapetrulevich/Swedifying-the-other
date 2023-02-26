package se.uu.swedifying.api.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.uu.swedifying.model.api.CreateAttestationRequest;
import se.uu.swedifying.model.entity.Attestation;
import se.uu.swedifying.service.AttestationService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/attestations")
public class AttestationsResources {
    private final AttestationService attestationService;

    @Autowired
    AttestationsResources(AttestationService attestationService) {
        this.attestationService = attestationService;
    }

    @PostMapping
    public ResponseEntity<Attestation> createAttestation(
            @RequestBody CreateAttestationRequest createAttestationRequest) {
        Attestation attestation = attestationService.createAttestation(createAttestationRequest);
        return ResponseEntity
                .created(URI.create("/api/v1/attestations/" + attestation.getAttestationId()))
                .body(attestation);
    }

    @GetMapping
    public ResponseEntity<List<Attestation>> getAllAttestations(
      @RequestParam(defaultValue = "") String morphNameType
      , @RequestParam(defaultValue = "") String etymology
    ) {
        if (morphNameType.isBlank() && etymology.isBlank()) {
            return ResponseEntity.ok(attestationService.getAllAttestations());
        } else {
            return ResponseEntity.ok(attestationService.getAllFiltered(
              morphNameType
              , etymology
              , 0
              , Integer.MAX_VALUE));
        }
    }

    @GetMapping("/{attestationId}")
    public ResponseEntity<Attestation> getAttestationById(@PathVariable long attestationId) {
        return ResponseEntity.ok(attestationService.getAttestationById(attestationId));
    }
}
