package se.uu.swedifying.model.entity;

import javax.persistence.*;

@Entity
public class Parish extends SubRegion {

  @ManyToOne
  @JoinColumn(name = "BELONGS_TO_PRECINCT_ID")
  private Precinct belongsTo;
}
