package se.uu.swedifying.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ETYMOLOGY")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Etymology {
  @Id
  @GeneratedValue
  @Column(name = "ETYMOLOGY_ID")
  private Long adaptationTypeId;

  @Column(name = "ETYMOLOGY_NAME")
  private String name;
}
