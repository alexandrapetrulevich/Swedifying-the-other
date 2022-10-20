package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "MAP_SIGNATURE")
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MapSignature {
  @Id
  @GeneratedValue
  @Column(name = "MAP_SIGNATURE_ID")
  private Long mapSignatureId;
  @Column(name = "MAP_SIGNATURE")
  private String mapSignature;
}
