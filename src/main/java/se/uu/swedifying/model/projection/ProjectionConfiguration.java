package se.uu.swedifying.model.projection;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import se.uu.swedifying.model.entity.LocalityType;


@Component
@Slf4j
public class ProjectionConfiguration implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
    log.info("*** configureRepositoryRestConfiguration");
    config.getProjectionConfiguration().addProjection(AdaptationTypeView.class);
    config.getProjectionConfiguration().addProjection(AttestationView.class);
    config.getProjectionConfiguration().addProjection(LandSurveyorView.class);
    config.getProjectionConfiguration().addProjection(LanguageView.class);
    config.getProjectionConfiguration().addProjection(LocalityTypeView.class);
    config.getProjectionConfiguration().addProjection(LocationView.class);
    config.getProjectionConfiguration().addProjection(MorphologicalDataView.class);
    config.getProjectionConfiguration().addProjection(NormalizedFormView.class);
    config.getProjectionConfiguration().addProjection(PartOfSourceView.class);
    config.getProjectionConfiguration().addProjection(RegionView.class);
    config.getProjectionConfiguration().addProjection(SourceFindingView.class);
    config.getProjectionConfiguration().addProjection(SourceView.class);
    config.getProjectionConfiguration().addProjection(SubRegionView.class);
    config.getProjectionConfiguration().addProjection(VariantFormView.class);
    log.info("configureRepositoryRestConfiguration DONE");
  }
}
