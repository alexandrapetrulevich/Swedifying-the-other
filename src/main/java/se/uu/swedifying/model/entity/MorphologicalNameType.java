package se.uu.swedifying.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MORPHOLOGICAL_NAME_TYPE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class MorphologicalNameType {
  @Id
  @GeneratedValue
  @Column(name = "MORPHOLOGICAL_NAME_TYPE_ID")
  private Long adaptationTypeId;

  @Column(name = "MORPHOLOGICAL_NAME_TYPE_NAME")
  private String name;
}
