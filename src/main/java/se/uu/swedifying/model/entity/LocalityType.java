package se.uu.swedifying.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "LOCALITY_TYPE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class LocalityType {
    @Id
    @GeneratedValue
    @Column(name = "LOCALITY_TYPE_ID")
    private Long localityTypeId;

    @Column(name = "LOCALITY_TYPE_NAME", nullable = false, unique = true)
    private String localityTypeName;

}
