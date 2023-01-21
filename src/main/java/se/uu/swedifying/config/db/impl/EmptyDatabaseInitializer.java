package se.uu.swedifying.config.db.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import se.uu.swedifying.config.db.DatabaseInitializer;


@Component
@Profile("!testdata")
@Slf4j
public class EmptyDatabaseInitializer implements DatabaseInitializer {
  @Override
  public void initDatabase() {
    log.info("*** Starting with an empty database - no initial test data added");
  }
}
