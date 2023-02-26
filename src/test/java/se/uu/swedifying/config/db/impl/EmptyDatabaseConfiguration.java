package se.uu.swedifying.config.db.impl;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import se.uu.swedifying.config.db.DatabaseInitializer;

@TestConfiguration
public class EmptyDatabaseConfiguration {
  @Bean
  public DatabaseInitializer databaseInitializer() {
    return new EmptyDatabaseInitializer();
  }
}
