package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SubRegion {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "SUB_REGION_ID", nullable = false)
  private Long subRegionId;

  private String name;

  @ManyToOne
  @JoinColumn(name = "BELONGS_TO_REGION_ID")
  private Region belongsTo;
}
