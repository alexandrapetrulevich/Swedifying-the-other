package se.uu.swedifying.model.api;

import java.util.Date;

/**
 * A DTO for the {@link se.uu.swedifying.model.entity.MapSource} entity
 */
public record CreateMapSourceRequest(
  Date dating
  , Long landSurveyorId
  , Long mapSignatureId
  , int mapSheet) {
}