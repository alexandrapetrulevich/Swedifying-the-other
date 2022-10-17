package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ADAPTATION_TYPE")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AdaptationType {
  @Id
  @GeneratedValue
  @Column(name = "ADAPTATION_TYPE_ID")
  private Long adaptationTypeId;

  @Column(name = "ADAPTATION_TYPE_NAME")
  private String name;
}
