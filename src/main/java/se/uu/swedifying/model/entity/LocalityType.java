package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "LOCALITY_TYPE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LocalityType {
    @Id
    @GeneratedValue
    @Column(name = "LOCALITY_TYPE_ID")
    private Long localityTypeId;

    @Column(name = "LOCALITY_TYPE_NAME", nullable = false, unique = true)
    private String localityTypeName;

    public LocalityType(String localityTypeName) {
        this.localityTypeName = localityTypeName;
    }
    public LocalityType(long localityTypeId, String localityTypeName) {
        this.localityTypeId = localityTypeId;
        this.localityTypeName = localityTypeName;
    }

}
