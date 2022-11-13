package se.uu.swedifying.repository;

import org.springframework.data.repository.CrudRepository;
import se.uu.swedifying.model.entity.Language;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Long> {
  List<Language> findByLanguageNameContains(String languageNameFilter);

  Language findByLanguageCode(String languageCodeFilter);
  List<Language> findByLanguageCodeContains(String languageCodeFilter);

  List<Language> findByLanguageNameContainsAndLanguageCodeContains(
    String languageNameFilter
    , String languageCodeFilter);
}
