package se.uu.swedifying.model.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class District extends SubRegion {
}
