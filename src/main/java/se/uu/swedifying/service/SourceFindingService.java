package se.uu.swedifying.service;

import se.uu.swedifying.model.api.CreateSourceFindingRequest;
import se.uu.swedifying.model.entity.SourceFinding;

import java.util.List;

public interface SourceFindingService {
  SourceFinding createSourceFinding(CreateSourceFindingRequest createSourceFindingRequest);
  List<SourceFinding> getAllSourceFindings();
}
