package se.uu.swedifying.model.api;

import java.time.LocalDate;

/**
 * A DTO for the {@link se.uu.swedifying.model.entity.SourceFinding} entity
 */
public record CreateSourceFindingRequest(
  Long sourceId
  , Long partOfSourceId) {
}