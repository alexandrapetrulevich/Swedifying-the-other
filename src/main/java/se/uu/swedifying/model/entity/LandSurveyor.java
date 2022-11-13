package se.uu.swedifying.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "LAND_SURVEYOR")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class LandSurveyor {
  @Id
  @GeneratedValue
  @Column(name = "LAND_SURVEYOR_ID")
  private Long landSurveyorId;
  @Column(name = "NAME")
  private String name;
}
