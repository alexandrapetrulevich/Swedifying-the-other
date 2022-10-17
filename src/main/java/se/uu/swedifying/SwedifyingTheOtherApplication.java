package se.uu.swedifying;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import se.uu.swedifying.model.entity.*;
import se.uu.swedifying.model.util.ExistenceType;
import se.uu.swedifying.repository.*;

@SpringBootApplication
public class SwedifyingTheOtherApplication implements CommandLineRunner {

	@Autowired
	AttestationRepository attestationRepository;
	@Autowired
	MorphologicalNameTypeRepository morphologicalNameTypeRepository;

	@Autowired
	EtymologyRepository etymologyRepository;

	@Autowired
	LocalityTypeRepository localityTypeRepository;

	@Autowired
	LocationRepository locationRepository;

	@Autowired
	AttestationLemmaFromRepository attestationLemmaFromRepository;

	@Autowired
	AdaptationTypeRepository adaptationTypeRepository;

	public static void main(String[] args) {
		SpringApplication.run(SwedifyingTheOtherApplication.class, args);
	}

	@Override
	public void run(String... args) {
		LocalityType bebyggelseBy = new LocalityType("bebyggelse, by");
		localityTypeRepository.save(bebyggelseBy);

		Location location_1 = Location.builder()
			.localityType(bebyggelseBy)
			.realOrFictional(ExistenceType.REAL)
			.build();
		locationRepository.save(location_1);
		MorphologicalNameType fras = MorphologicalNameType.builder().name("fras").build();
		morphologicalNameTypeRepository.save(fras);
		Etymology ty = Etymology.builder().name("ty").build();
		etymologyRepository.save(ty);
		AttestationLemmaForm grosseErnsthoff = AttestationLemmaForm
			.builder().lemmaFormName("Grosse Ernsthoff").build();
		attestationLemmaFromRepository.save(grosseErnsthoff);

		Attestation attestation_1 = Attestation
			.builder()
			.originalForm("Grosse Ernshoff[s] Åkermark Uthi Wolgasts District")
			.location(location_1)
			.morphologicalNameType(fras)
			.determinationClause("")
			.mainClauseInPhrase("")
			.simpleRootMorpheme("")
			.diversionBase("")
			.mainClauseInSms("hof")
			.etymology(ty)
			.adaptedToSwedish(false)
			.notes("Some notes")
			.lemmaForm(grosseErnsthoff)
			.build();

		attestationRepository.save(attestation_1);

		LocalityType distrikt = new LocalityType("distrikt");
		localityTypeRepository.save(distrikt);
		Location location_2 = Location.builder().localityType(distrikt).realOrFictional(ExistenceType.REAL).build();
		locationRepository.save(location_2);

		AdaptationType morfologiskAnpassningAvForleden =
			AdaptationType.builder().name("morfologisk anpassning av förleden").build();
		adaptationTypeRepository.save(morfologiskAnpassningAvForleden);

		AttestationLemmaForm wolgastDistrikt = AttestationLemmaForm.builder().lemmaFormName("Wolgasts distrikt").build();
		attestationLemmaFromRepository.save(wolgastDistrikt);

		Attestation attestation_2 = Attestation
			.builder()
			.attestationId(2L)
			.originalForm("Grosse Ernshoff[s] Åkermark Uthi Wolgasts District")
			.location(location_2)
			.morphologicalNameType(morphologicalNameTypeRepository.findByName("fras"))
			.determinationClause("Wolgasts")
			.mainClauseInPhrase("distrikt")
			.simpleRootMorpheme("")
			.diversionBase("")
			.mainClauseInSms("")
			.etymology(etymologyRepository.findByName("ty"))
			.adaptedToSwedish(true)
			.adaptationType(morfologiskAnpassningAvForleden)
			.notes("Some notes")
			.lemmaForm(wolgastDistrikt)
			.build();
		attestationRepository.save(attestation_2);

		LocalityType bebyggelseStad = new LocalityType("bebyggelse, stad");
		localityTypeRepository.save(bebyggelseStad);
		Location location_3 = Location.builder().localityType(bebyggelseStad).realOrFictional(ExistenceType.REAL).build();
		locationRepository.save(location_3);
		MorphologicalNameType avl = MorphologicalNameType.builder().name("avl").build();
		morphologicalNameTypeRepository.save(avl);
		Etymology slav = Etymology.builder().name("slav").build();
		etymologyRepository.save(slav);
		AttestationLemmaForm wolgast = AttestationLemmaForm.builder().lemmaFormName("Wolgasts").build();
		attestationLemmaFromRepository.save(wolgast);


		Attestation attestation_3 = Attestation
			.builder()
			.attestationId(3L)
			.originalForm("Wolgasts Stadz Grentz")
			.location(location_3)
			.morphologicalNameType(avl)
			.determinationClause("")
			.mainClauseInPhrase("")
			.simpleRootMorpheme("")
			.diversionBase("Voligost")
			.mainClauseInSms("")
			.etymology(slav)
			.adaptedToSwedish(false)
			.notes("Some notes")
			.lemmaForm(wolgast)
			.build();
		attestationRepository.save(attestation_3);
	}

}
