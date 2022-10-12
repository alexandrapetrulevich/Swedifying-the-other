package se.uu.swedifying.api.rest.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.uu.swedifying.model.api.AttestationDto;
import se.uu.swedifying.model.api.CreateAttestationRequest;
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
    public ResponseEntity<AttestationDto> createAttestation(
            @RequestBody CreateAttestationRequest createAttestationRequest) {
        AttestationDto attestationDto = attestationService.createAttestation(createAttestationRequest);
        return ResponseEntity
                .created(URI.create("/api/v1/attestations/" + attestationDto.attestationId()))
                .body(attestationDto);
    }

    @GetMapping
    public ResponseEntity<List<AttestationDto>> getAllAttestations() {
        return ResponseEntity.ok(attestationService.getAllAttestations());
    }

    @GetMapping("/{attestationId}")
    public ResponseEntity<AttestationDto> getAttestationById(@PathVariable long attestationId) {
        return ResponseEntity.ok(attestationService.getAttestationById(attestationId));
    }
}
