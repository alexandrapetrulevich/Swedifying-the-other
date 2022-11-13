package se.uu.swedifying.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "LOCATION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Builder
public class Location {
    @Id
    @GeneratedValue
    @Column(name = "LOCATION_ID")
    private Long locationId;

    @Column(name = "LONGITUDE")
    private double longitude;
    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "MODERN_LOOKUP_FORM")
    private String modernLookupForm;

    @ManyToOne
    @JoinColumn(name = "DISTRICT_OR_PARISH_ID")
    private SubRegion districtOrParish;

    @ManyToOne
    @JoinColumn(name = "LOCALITY_TYPE_ID")
    private LocalityType localityType;

}
