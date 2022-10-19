package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Region {
  @Id
  @GeneratedValue
  @Column(name = "REGION_ID")
  private Long regionId;

  @Column(name = "REGION_NAME", nullable = false, unique = true)
  private String regionName;

}
