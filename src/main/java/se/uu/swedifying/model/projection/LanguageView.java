package se.uu.swedifying.model.projection;

import org.springframework.data.rest.core.config.Projection;
import se.uu.swedifying.model.entity.Language;

/**
 * A Projection for the {@link se.uu.swedifying.model.entity.Language} entity
 */
@Projection(types = {Language.class})
public interface LanguageView {
  Long getLanguageId();

  String getLanguageName();

  String getLanguageCode();
}