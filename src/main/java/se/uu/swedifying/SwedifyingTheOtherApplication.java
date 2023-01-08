package se.uu.swedifying;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.uu.swedifying.config.db.DatabaseInitializer;

@SpringBootApplication
public class SwedifyingTheOtherApplication implements CommandLineRunner {

  private final DatabaseInitializer databaseInitializer;

  @Autowired
  public SwedifyingTheOtherApplication(DatabaseInitializer databaseInitializer) {
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
