package se.uu.swedifying.model.util;

import lombok.*;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Data
@Builder
public class ComparativeFormInformation {
  private String comparativeFormFromMediatingSource;
  private String mediatingSourceInformation;
}
