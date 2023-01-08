package se.uu.swedifying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.uu.swedifying.model.api.CreateMapSourceRequest;
import se.uu.swedifying.model.entity.MapSource;
import se.uu.swedifying.model.entity.Source;
import se.uu.swedifying.repository.LandSurveyorRepository;
import se.uu.swedifying.repository.MapSignatureRepository;
import se.uu.swedifying.repository.SourceRepository;
import se.uu.swedifying.service.SourceService;

import java.util.List;

@Service
class SourceServiceImpl implements SourceService {

  private final SourceRepository sourceRepository;
  private final LandSurveyorRepository landSurveyorRepository;
  private final MapSignatureRepository mapSignatureRepository;

  @Autowired
  SourceServiceImpl(
    SourceRepository sourceRepository
    , LandSurveyorRepository landSurveyorRepository
    , MapSignatureRepository mapSignatureRepository) {
    this.sourceRepository = sourceRepository;
    this.landSurveyorRepository = landSurveyorRepository;
    this.mapSignatureRepository = mapSignatureRepository;
  }

  @Override
  public List<Source> getAllSources() {
    return sourceRepository.findAll();
  }

  @Override
  public Source createSource(CreateMapSourceRequest createMapSourceRequest) {
    MapSource mapSource = MapSource
      .builder()
      .dating(createMapSourceRequest.dating())
      .mapSheet(createMapSourceRequest.mapSheet())
      .landSurveyor(landSurveyorRepository.findById(createMapSourceRequest.landSurveyorId()).orElseThrow())
      .mapSignature(mapSignatureRepository.findById(createMapSourceRequest.mapSignatureId()).orElseThrow())
      .build();
    return sourceRepository.save(mapSource);
  }
}
