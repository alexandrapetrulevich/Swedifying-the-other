package se.uu.swedifying.model.api;

import lombok.Data;

import java.time.LocalDate;

/**
 * A DTO for the {@link se.uu.swedifying.model.entity.Source} entity
 */
public record CreateSourceRequest(LocalDate dating, Long landSurveyorId) {
}