package se.uu.swedifying.config.db;

import org.springframework.stereotype.Component;

@Component
public interface DatabaseInitializer {
  void initDatabase();
}
