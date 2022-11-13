package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table(name = "SUB_REGION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public abstract class SubRegion {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "SUB_REGION_ID", nullable = false)
  private Long subRegionId;

  @Column(name = "NAME")
  private String name;

  @ManyToOne
  @JoinColumn(name = "BELONGS_TO_REGION_ID")
  private Region belongsToRegion;
}
