package se.uu.swedifying.service;

import se.uu.swedifying.model.api.CreateMapSourceRequest;
import se.uu.swedifying.model.entity.Source;

import java.util.List;

public interface SourceService {
  List<Source> getAllSources();
  Source createSource(CreateMapSourceRequest createMapSourceRequest);
}
