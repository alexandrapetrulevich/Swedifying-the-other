package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.MapSignature} entity
 */
@Projection(types = {MapSignatureView.class})
public interface MapSignatureView {
  Long getMapSignatureId();

  String getMapSignature();
}