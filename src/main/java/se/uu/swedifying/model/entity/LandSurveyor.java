package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "LAND_SURVEYOR")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class LandSurveyor {
  @Id
  @GeneratedValue
  @Column(name = "LAND_SURVEYOR_ID")
  private Long landSurveyorId;
  @Column(name = "FIRST_NAME")
  private String firstName;
  @Column(name = "LAST_NAME")
  private String lastName;

  @Builder
  private LandSurveyor(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }
}
