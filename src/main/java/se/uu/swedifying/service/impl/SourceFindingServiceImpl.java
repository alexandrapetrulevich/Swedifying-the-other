package se.uu.swedifying.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.uu.swedifying.model.api.CreateSourceFindingRequest;
import se.uu.swedifying.model.entity.SourceFinding;
import se.uu.swedifying.repository.PartOfSourceRepository;
import se.uu.swedifying.repository.SourceFindingRepository;
import se.uu.swedifying.repository.SourceRepository;
import se.uu.swedifying.service.SourceFindingService;

import java.util.List;

@Service
public class SourceFindingServiceImpl implements SourceFindingService {
  private final SourceFindingRepository sourceFindingRepository;
  private final SourceRepository sourceRepository;
  private final PartOfSourceRepository partOfSourceRepository;

  @Autowired
  SourceFindingServiceImpl(
    SourceFindingRepository sourceFindingRepository
    , SourceRepository sourceRepository
    , PartOfSourceRepository partOfSourceRepository) {
    this.sourceFindingRepository = sourceFindingRepository;
    this.sourceRepository = sourceRepository;
    this.partOfSourceRepository = partOfSourceRepository;
  }

  @Override
  public SourceFinding createSourceFinding(CreateSourceFindingRequest createSourceFindingRequest) {
    SourceFinding sourceFinding = SourceFinding
      .builder()
      .source(sourceRepository
        .findById(createSourceFindingRequest.sourceId()).orElseThrow())
      .partOfSource(partOfSourceRepository
        .findById(createSourceFindingRequest.partOfSourceId()).orElseThrow())
      .build();
    return sourceFindingRepository.save(sourceFinding);
  }

  @Override
  public List<SourceFinding> getAllSourceFindings() {
    return sourceFindingRepository.findAll();
  }
}
