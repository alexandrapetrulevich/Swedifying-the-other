package se.uu.swedifying.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "LOCALITY_TYPE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocalityType {
    @Id
    @GeneratedValue
    @Column(name = "LOCALITY_TYPE_ID")
    private Long localityTypeId;

}
