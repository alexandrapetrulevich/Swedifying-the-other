package se.uu.swedifying.model.entity;

import lombok.*;
import se.uu.swedifying.model.util.IsAdaptedToSwedishType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "VARIANT_FORM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class VariantForm {
    @Id
    @GeneratedValue
    @Column(name = "VARIANT_FORM_ID")
    private Long variantFormId;

    @Column(name = "VARIANT_FORM")
    private String variantForm;

    @Column(name = "IS_ADAPTED_TO_SWEDISH")
    private IsAdaptedToSwedishType isAdaptedToSwedish;

    @ManyToMany
    @JoinTable(
      name = "VARIANT_TO_ADAPTATION_TYPE_RELATION",
      joinColumns = @JoinColumn(name = "VARIANT_FORM_ID"),
      inverseJoinColumns = @JoinColumn(name = "ADAPTATION_TYPE_ID"))
    @Singular
    private List<AdaptationType> adaptationTypes;

    @ManyToOne
    @JoinColumn(name = "NORMALIZED_FORM_ID")
    private NormalizedForm normalizedForm;
}
