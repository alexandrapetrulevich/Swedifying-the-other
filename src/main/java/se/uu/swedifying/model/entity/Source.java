package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "SOURCE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Source {
  @Id
  @GeneratedValue
  @Column(name = "SOURCE_ID")
  private Long sourceId;

  private LocalDate dating;


  @ManyToOne
  @JoinColumn(name = "LAND_SURVEYOR_ID")
  private LandSurveyor landSurveyor;

}
