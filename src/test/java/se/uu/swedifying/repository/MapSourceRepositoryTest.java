package se.uu.swedifying.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import se.uu.swedifying.config.db.impl.EmptyDatabaseConfiguration;
import se.uu.swedifying.model.entity.MapSource;

import javax.persistence.Query;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(EmptyDatabaseConfiguration.class)
class MapSourceRepositoryTest {

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private MapSourceRepository mapSourceRepository;

  @Test
  void assertCorrectDate() {
    Calendar calendar = new GregorianCalendar(1694, Calendar.JUNE, 20);
    MapSource mapSource = MapSource
      .builder()
      .mapSignature(null)
      .mapSheet(1)
      .landSurveyor(null)
      .dating(
        Date.from(
          LocalDate.of(1694, Month.JUNE, 20)
            .atTime(12, 0)
            .atZone(ZoneId.systemDefault())
            .toInstant()))
      .build();

    testEntityManager.persist(mapSource);

    List<MapSource> mapSourceList = mapSourceRepository.findAll();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    assertEquals(1, mapSourceList.size());
    assertEquals(
      dateFormat.format(calendar.getTime())
      , dateFormat.format(mapSourceList.get(0).getDating()));

    Query q = testEntityManager
      .getEntityManager()
      .createNativeQuery("SELECT DATING FROM SOURCE");
    System.out.println("Result list: " + q.getResultList());

  }
}