package se.uu.swedifying.model.entity;

import lombok.*;
import se.uu.swedifying.model.util.ExistenceType;

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

    @Column(name = "REAL_OR_FICTIONAL")
    private ExistenceType realOrFictional;
    @Column(name = "LONGITUDE")
    private double longitude;
    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "ENGLISH_FORM")
    private String englishForm;

    @Setter
    @ManyToOne
    @JoinColumn(name = "LOCALITY_TYPE_ID")
    private LocalityType localityType;

}
