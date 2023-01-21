package se.uu.swedifying;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.uu.swedifying.config.db.DatabaseInitializer;

@SpringBootApplication
@Slf4j
public class SwedifyingTheOtherApplication implements CommandLineRunner {

  private final DatabaseInitializer databaseInitializer;

  @Autowired
  public SwedifyingTheOtherApplication(DatabaseInitializer databaseInitializer) {
    log.info("""
      Using %s as DatabaseInitializer.
      """.formatted(databaseInitializer != null ? databaseInitializer.getClass().getName() : "null"));
    this.databaseInitializer = databaseInitializer;
  }

  public static void main(String[] args) {
    SpringApplication.run(SwedifyingTheOtherApplication.class, args);
  }

  @Override
  public void run(String... args) {
    databaseInitializer.initDatabase();
  }

}
