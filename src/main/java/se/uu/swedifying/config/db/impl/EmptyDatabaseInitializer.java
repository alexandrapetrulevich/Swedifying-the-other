package se.uu.swedifying.config.db.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import se.uu.swedifying.config.db.DatabaseInitializer;


@Component
// Listing profiles means OR, hence true if "!testdata" OR "postgresql"
@Profile({"!testdata", "postgresql", "prod"})
@Slf4j
class EmptyDatabaseInitializer implements DatabaseInitializer {
  @Override
  public void initDatabase() {
    log.info("*** Starting with an empty database - no initial test data added");
  }
}
