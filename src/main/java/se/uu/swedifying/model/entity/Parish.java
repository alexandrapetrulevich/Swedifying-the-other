package se.uu.swedifying.model.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Parish extends SubRegion {
  @ManyToOne
  @JoinColumn(name = "BELONGS_TO_PRECINCT_ID")
  private Precinct belongsToPrecinct;
}
