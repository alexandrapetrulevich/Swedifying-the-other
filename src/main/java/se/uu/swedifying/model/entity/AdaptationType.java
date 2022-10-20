package se.uu.swedifying.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ADAPTATION_TYPE")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class AdaptationType {
  @Id
  @GeneratedValue
  @Column(name = "ADAPTATION_TYPE_ID")
  private Long adaptationTypeId;

  @Column(name = "NAME", nullable = false, unique = true)
  private String name;
}
