package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ATTESTATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Attestation {
    @Id
    @GeneratedValue
    @Column(name = "ATTESTATION_ID")
    private Long attestationId;

    @Column(name = "ORIGINAL_FORM")
    private String originalForm;
    
    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location location;

    @Builder
    private Attestation(String originalForm, Location location) {
        this.originalForm = originalForm;
        this.location = location;
    }

}
