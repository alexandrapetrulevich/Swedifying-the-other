package se.uu.swedifying.model.api;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link se.uu.swedifying.model.entity.MapSource} entity
 */
public record CreateMapSourceRequest(
  LocalDate dating
  , Long landSurveyorId
  , Long mapSignatureId
  , int mapSheet) {
}