package se.uu.swedifying.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "LANGUAGE")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Language {
  @Id
  @GeneratedValue
  @Column(name = "LANGUAGE_ID")
  private Long languageId;

  @Column(name = "LANGUAGE_NAME", nullable = false, unique = true)
  private String languageName;

  @Column(name = "LANGUAGE_CODE", nullable = false, unique = true)
  private String languageCode;
}
