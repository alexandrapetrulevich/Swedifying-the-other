package se.uu.swedifying;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.uu.swedifying.model.entity.*;
import se.uu.swedifying.model.util.ComparativeFormInformation;
import se.uu.swedifying.model.util.IsAdaptedToSwedishType;
import se.uu.swedifying.model.util.MorphologicalData;
import se.uu.swedifying.model.util.MorphologicalNameType;
import se.uu.swedifying.repository.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class SwedifyingTheOtherApplication implements CommandLineRunner {
  @Autowired
  AttestationRepository attestationRepository;
  @Autowired
  LocalityTypeRepository localityTypeRepository;
  @Autowired
  LocationRepository locationRepository;
  @Autowired
  AttestationNormalizedFormRepository attestationNormalizedFormRepository;
  @Autowired
  AdaptationTypeRepository adaptationTypeRepository;
  @Autowired
  LanguageRepository languageRepository;
  @Autowired
  RegionRepository regionRepository;
  @Autowired
  SubRegionRepository subRegionRepository;
  @Autowired
  LandSurveyorRepository landSurveyorRepository;
  @Autowired
  PartOfSourceRepository partOfSourceRepository;
  @Autowired
  SourceRepository sourceRepository;
  @Autowired
  SourceFindingRepository sourceFindingRepository;

  @Autowired
  AttestationVariantFormRepository attestationVariantFormRepository;

  public static void main(String[] args) {
    SpringApplication.run(SwedifyingTheOtherApplication.class, args);
  }

  @Override
  public void run(String... args) {
    addLanguages();
    addLocalityTypes();
    addRegions();
    addSubRegions();
    addLandSurveyors();
    addAdaptationTypes();
    addPartsOfSources();
    Source source = addSources();
    List<SourceFinding> sourceFindings = addSourceFindings(source);
    addLocations();
    addNormalizedForms();
    addVariantForms();

    attestationRepository.save(
      Attestation
        .builder()
        .originalForm("Grosse Ernshoff[s] Åkermark Uthi Wolgasts District")
        .variantForm(attestationVariantFormRepository.findByVariantForm("Grosse Ernsthoff"))
        .location(locationRepository.findByModernLookupForm("Gross Ernsthof"))
        .sourceFinding(sourceFindings.get(0))
        .notes("Niemeyer 2:32f.")
        .build());
    attestationRepository.save(
      Attestation
        .builder()
        .originalForm("Grosse Ernshoff[s] Åkermark Uthi Wolgasts District")
        .variantForm(attestationVariantFormRepository.findByVariantForm("Wolgasts distrikt"))
        .location(locationRepository.findByModernLookupForm(""))
        .sourceFinding(sourceFindings.get(1))
        .notes("Distriktsnamnet är anpassat till sv dock ej bebyggelsenamnet Wolgast som har slavisk etymologi och som medierats via tyska. I notarum står inte sällan \"Wolgasts ampt\".")
        .build());
    attestationRepository.save(
      Attestation
        .builder()
        .originalForm("Wolgasts Stadz Grentz")
        .variantForm(attestationVariantFormRepository.findByVariantForm("Wolgast"))
        .location(locationRepository.findByModernLookupForm("Wolgast"))
        .sourceFinding(sourceFindings.get(2))
        .notes("Eichler & Walther 1988:300")
        .build());
  }

  private void addVariantForms() {
    attestationVariantFormRepository
      .save(AttestationVariantForm
        .builder()
        .variantForm("Grosse Ernsthoff")
        .isAdaptedToSwedish(IsAdaptedToSwedishType.NO)
        .normalizedForm(attestationNormalizedFormRepository.findByNormalizedForm("Grosse Ernsthoff"))
        .build());
    attestationVariantFormRepository
      .save(AttestationVariantForm
        .builder()
        .variantForm("Wolgasts distrikt")
        .isAdaptedToSwedish(IsAdaptedToSwedishType.YES)
        .adaptationType(
          List.of(adaptationTypeRepository.findByName("morfologisk anpassning av förleden")))
        .normalizedForm(attestationNormalizedFormRepository.findByNormalizedForm("Wolgasts distrikt"))
        .build());
    attestationVariantFormRepository
      .save(AttestationVariantForm
        .builder()
        .variantForm("Wolgast")
        .isAdaptedToSwedish(IsAdaptedToSwedishType.NO)
        .normalizedForm(attestationNormalizedFormRepository.findByNormalizedForm("Wolgast"))
        .build());
  }

  private void addNormalizedForms() {
    attestationNormalizedFormRepository.save(
      AttestationNormalizedForm
        .builder()
        .normalizedForm("Grosse Ernsthoff")
        //.morphologicalNameType(MorphologicalNameType.PHRASE)
        .morphologicalNameType(MorphologicalNameType.COMPOSITION)
        .morphologicalNameTypeIsShaky(false)
        .morphologicalData(
          MorphologicalData
            .builder()
            .determinationClauseInComposition("Ernst")
            .mainClauseInComposition("hof")
            .build())
        .comparativeFormInformation(
          ComparativeFormInformation
            .builder()
            .comparativeFormFromMediatingSource("1618 Ernsthoff")
            .mediatingSourceInformation("Lubinsche Karte")
            .build()
        )
        .etymology(languageRepository.findByLanguageCode("de"))
        .mediatingLanguage(null)
        .build());
    attestationNormalizedFormRepository.save(
      AttestationNormalizedForm
        .builder()
        .normalizedForm("Wolgasts distrikt")
        .morphologicalNameType(MorphologicalNameType.PHRASE)
        .morphologicalNameTypeIsShaky(false)
        .morphologicalData(
          MorphologicalData
            .builder()
            .determinationClauseInPhrase("Wolgasts")
            .mainClauseInPhrase("distrikt")
            .build())
        .comparativeFormInformation(
          ComparativeFormInformation
            .builder()
            .comparativeFormFromMediatingSource("Wolgastischer District, Amte Wolgast")
            .mediatingSourceInformation("Kahldensche Matrikel")
            .build()
        )
        .etymology(languageRepository.findByLanguageCode("de"))
        .mediatingLanguage(null)
        .build());

    attestationNormalizedFormRepository.save(
      AttestationNormalizedForm
        .builder()
        .normalizedForm("Wolgasts")
        .morphologicalNameType(MorphologicalNameType.DERIVATION)
        .morphologicalNameTypeIsShaky(false)
        .morphologicalData(
          MorphologicalData
            .builder()
            .derivationBase("Voligost")
            .derivationMorpheme("j")
            .build())
        .comparativeFormInformation(
          ComparativeFormInformation
            .builder()
            .comparativeFormFromMediatingSource("1140 castra hec, scilicet … Wologost : Wolgast; 1186 usque Wolegost et a Wolegost")
            .mediatingSourceInformation("PUB 1:33, 130")
            .build()
        )
        .etymology(languageRepository.findByLanguageCode("slav"))
        .mediatingLanguage(languageRepository.findByLanguageCode("de"))
        .build());
  }

  private void addLocations() {
    locationRepository.save(
      Location
        .builder()
        .modernLookupForm("Gross Ernsthof")
        .districtOrParish(subRegionRepository.findByName("Wolgasts distrikt"))
        .localityType(localityTypeRepository.findByLocalityTypeName("bebyggelse, by"))
        .build());
    locationRepository.save(
      Location
        .builder()
        .modernLookupForm("")
        .districtOrParish(subRegionRepository.findByName("Wolgasts distrikt"))
        .localityType(localityTypeRepository.findByLocalityTypeName("distrikt"))
        .build());
    locationRepository.save(
      Location
        .builder()
        .modernLookupForm("Wolgast")
        .districtOrParish(subRegionRepository.findByName("Wolgasts distrikt"))
        .localityType(localityTypeRepository.findByLocalityTypeName("bebyggelse, stad"))
        .build());
  }

  private List<SourceFinding> addSourceFindings(Source source) {
    return List.of(
      sourceFindingRepository.save(
        SourceFinding
          .builder()
          .partOfSource(partOfSourceRepository.findByPartOfSourceName("Rubrik"))
          .separateDescription("Grosse Ernsthåff, Grosse Ernshoff, Grosse Erns=hoff")
          .source(source)
          .build())
      , sourceFindingRepository.save(
        SourceFinding
          .builder()
          .partOfSource(partOfSourceRepository.findByPartOfSourceName("Rubrik"))
          .source(source)
          .build())
      , sourceFindingRepository.save(
        SourceFinding
          .builder()
          .partOfSource(partOfSourceRepository.findByPartOfSourceName("Gräns"))
          .source(source)
          .build()));
  }

  private MapSource addSources() {
    return sourceRepository.save(
      MapSource
        .builder()
        .signature("BI")
        .mapSheet(1)
        .dating(LocalDate.of(1694, Month.JUNE, 20))
        .landSurveyor(landSurveyorRepository.findByName("Simon Skragge"))
        .build());
  }

  private void addPartsOfSources() {
    partOfSourceRepository.save(
      PartOfSource
        .builder()
        .partOfSourceName("Rubrik")
        .build());
    partOfSourceRepository.save(
      PartOfSource
        .builder()
        .partOfSourceName("Kartkroppen")
        .build());
    partOfSourceRepository.save(
      PartOfSource
        .builder()
        .partOfSourceName("Gränsmarkering")
        .build());
    partOfSourceRepository.save(
      PartOfSource
        .builder()
        .partOfSourceName("Utanför kartkroppen")
        .build());
  }

  private void addAdaptationTypes() {
    adaptationTypeRepository.save(
      AdaptationType
        .builder()
        .name("morfologisk anpassning av förleden")
        .build());
    adaptationTypeRepository.save(
      AdaptationType
        .builder()
        .name("översättning av huvudleden")
        .build());
  }

  private void addLandSurveyors() {
    landSurveyorRepository.save(LandSurveyor.builder().name("Simon Skragge").build());
  }

  private void addSubRegions() {
    subRegionRepository.save(
      District
        .builder()
        .belongsToRegion(regionRepository.findByRegionName("Pommern"))
        .name("Wolgasts distrikt")
        .build());
  }

  private void addRegions() {
    regionRepository.save(Region.builder().regionName("Pommern").build());
    regionRepository.save(Region.builder().regionName("Finland").build());
    regionRepository.save(Region.builder().regionName("Västerbotten").build());
  }

  private void addLocalityTypes() {
    localityTypeRepository.save(LocalityType.builder().localityTypeName("bebyggelse, by").build());
    localityTypeRepository.save(LocalityType.builder().localityTypeName("distrikt").build());
    localityTypeRepository.save(LocalityType.builder().localityTypeName("bebyggelse, stad").build());
  }

  private void addLanguages() {
    //INSERT INTO LANGUAGE (LANGUAGE_ID, LANGUAGE_NAME, LANGUAGE_CODE) VALUES (1, 'Swedish', 'sv');
    //INSERT INTO LANGUAGE(LANGUAGE_ID, LANGUAGE_NAME, LANGUAGE_CODE) VALUES(2, 'Latin', 'la');
    //INSERT INTO LANGUAGE(LANGUAGE_ID, LANGUAGE_NAME, LANGUAGE_CODE) VALUES(3, 'Finnish', 'fi');
    //INSERT INTO LANGUAGE(LANGUAGE_ID, LANGUAGE_NAME, LANGUAGE_CODE) VALUES(4, 'German', 'de');
    //INSERT INTO LANGUAGE(LANGUAGE_ID, LANGUAGE_NAME, LANGUAGE_CODE) VALUES(5, 'English', 'en');
    languageRepository.save(Language
      .builder()
      .languageName("Swedish")
      .languageCode("sv")
      .build());
    languageRepository.save(Language
      .builder()
      .languageName("Latin")
      .languageCode("la")
      .build());
    languageRepository.save(Language
      .builder()
      .languageName("Finnish")
      .languageCode("fi")
      .build());
    languageRepository.save(Language
      .builder()
      .languageName("German")
      .languageCode("de")
      .build());
    languageRepository.save(Language
      .builder()
      .languageName("English")
      .languageCode("en")
      .build());
    languageRepository.save(Language
      .builder()
      .languageName("Slavic")
      .languageCode("slav")
      .build());
  }

}
