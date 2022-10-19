package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PART_OF_SOURCE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class PartOfSource {
  @Id
  @GeneratedValue
  @Column(name = "PART_OF_SOURCE_ID")
  private Long partOfSourceId;

  @Column(name = "PART_OF_SOURCE_NAME", nullable = false, unique = true)
  private String partOfSourceName;
}
