package se.uu.swedifying.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "REGION")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Region {
  @Id
  @GeneratedValue
  @Column(name = "REGION_ID")
  private Long regionId;

  @Column(name = "REGION_NAME", nullable = false, unique = true)
  private String regionName;

}
