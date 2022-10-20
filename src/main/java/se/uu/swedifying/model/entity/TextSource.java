package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class TextSource extends Source {
  @Column(name = "NAME")
  private String name;
  @Column(name = "SUB_SECTION")
  private String subSection;
  @Column(name = "PAGE")
  private int page;
}
