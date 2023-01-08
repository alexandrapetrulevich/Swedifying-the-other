package se.uu.swedifying.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SOURCE")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public abstract class Source {
  @Id
  @GeneratedValue
  @Column(name = "SOURCE_ID")
  private Long sourceId;

  @Column(name = "DATING", columnDefinition = "DATE")
  @Temporal(TemporalType.DATE)
  // Have to use Date to get correct old dates apparently
  // The SourceView converts to LocalDate
  private Date dating;

  @ManyToOne
  @JoinColumn(name = "LAND_SURVEYOR_ID")
  private LandSurveyor landSurveyor;
}
