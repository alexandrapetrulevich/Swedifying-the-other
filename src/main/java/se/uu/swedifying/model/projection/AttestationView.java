package se.uu.swedifying.model.projection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.Attestation;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.Attestation} entity
 */
@Projection(
  name = "attestationView"
  , types = {Attestation.class}
)
public interface AttestationView {
  @Value("#{target.attestationId}")
  Long getAttestationId();

  String getOriginalForm();

  String getNotes();

  //@Value("#{target.getVariantForm().getVariantForm()}")
  //String getVariantForm();
  VariantFormView getVariantForm();

  LocationView getLocation();

  SourceFindingView getSourceFinding();

}