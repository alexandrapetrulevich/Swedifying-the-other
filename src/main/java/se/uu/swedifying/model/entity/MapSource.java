package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class MapSource extends Source {
  @ManyToOne
  @JoinColumn(name = "MAP_SIGNATURE_ID")
  private MapSignature mapSignature;
  @Column(name = "MAP_SHEET")
  private int mapSheet;
}
