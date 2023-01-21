CREATE SEQUENCE hibernate_sequence START WITH 1 INCREMENT BY 1;

CREATE TABLE adaptation_type (
  adaptation_type_id BIGINT NOT NULL,
   name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_adaptation_type PRIMARY KEY (adaptation_type_id)
);

CREATE TABLE attestation (
  attestation_id BIGINT NOT NULL,
   original_form VARCHAR(255) NOT NULL,
   variant_form_id BIGINT,
   location_id BIGINT,
   source_finding_id BIGINT,
   notes TEXT,
   CONSTRAINT pk_attestation PRIMARY KEY (attestation_id)
);

CREATE TABLE land_surveyor (
  land_surveyor_id BIGINT NOT NULL,
   name VARCHAR(255),
   CONSTRAINT pk_land_surveyor PRIMARY KEY (land_surveyor_id)
);

CREATE TABLE language (
  language_id BIGINT NOT NULL,
   language_name VARCHAR(255) NOT NULL,
   language_code VARCHAR(255) NOT NULL,
   CONSTRAINT pk_language PRIMARY KEY (language_id)
);

CREATE TABLE locality_type (
  locality_type_id BIGINT NOT NULL,
   locality_type_name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_locality_type PRIMARY KEY (locality_type_id)
);

CREATE TABLE location (
  location_id BIGINT NOT NULL,
   longitude DOUBLE NOT NULL,
   latitude DOUBLE NOT NULL,
   modern_lookup_form VARCHAR(255),
   district_or_parish_id BIGINT,
   locality_type_id BIGINT,
   CONSTRAINT pk_location PRIMARY KEY (location_id)
);

CREATE TABLE map_signature (
  map_signature_id BIGINT NOT NULL,
   map_signature VARCHAR(255),
   CONSTRAINT pk_map_signature PRIMARY KEY (map_signature_id)
);

CREATE TABLE normalized_form (
  normalized_form_id BIGINT NOT NULL,
   normalized_form VARCHAR(255),
   morphological_name_type INT,
   morphological_name_type_is_shaky BOOLEAN NOT NULL,
   comparative_form_information TEXT,
   etymology_language_id BIGINT,
   mediating_language_id BIGINT,
   determination_clause_in_phrase VARCHAR(255),
   main_clause_in_phrase VARCHAR(255),
   simple_root_morpheme VARCHAR(255),
   derivation_base VARCHAR(255),
   derivation_morpheme VARCHAR(255),
   determination_clause_in_composition VARCHAR(255),
   joint_morpheme_in_composition VARCHAR(255),
   main_clause_in_composition VARCHAR(255),
   CONSTRAINT pk_normalized_form PRIMARY KEY (normalized_form_id)
);

CREATE TABLE part_of_source (
  part_of_source_id BIGINT NOT NULL,
   part_of_source_name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_part_of_source PRIMARY KEY (part_of_source_id)
);

CREATE TABLE region (
  region_id BIGINT NOT NULL,
   region_name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_region PRIMARY KEY (region_id)
);

CREATE TABLE source (
  source_id BIGINT NOT NULL,
   dtype VARCHAR(31),
   dating date,
   land_surveyor_id BIGINT,
   map_signature_id BIGINT,
   map_sheet INT,
   name VARCHAR(255),
   sub_section VARCHAR(255),
   page INT,
   CONSTRAINT pk_source PRIMARY KEY (source_id)
);

CREATE TABLE source_finding (
  source_finding_id BIGINT NOT NULL,
   source_id BIGINT,
   part_of_source_type_id BIGINT,
   CONSTRAINT pk_source_finding PRIMARY KEY (source_finding_id)
);

CREATE TABLE sub_region (
  sub_region_id BIGINT NOT NULL,
   dtype VARCHAR(31),
   name VARCHAR(255),
   belongs_to_region_id BIGINT,
   belongs_to_precinct_id BIGINT,
   CONSTRAINT pk_sub_region PRIMARY KEY (sub_region_id)
);

CREATE TABLE variant_form (
  variant_form_id BIGINT NOT NULL,
   variant_form VARCHAR(255),
   is_adapted_to_swedish INT,
   normalized_form_id BIGINT,
   CONSTRAINT pk_variant_form PRIMARY KEY (variant_form_id)
);

CREATE TABLE variant_to_adaptation_type_relation (
  adaptation_type_id BIGINT NOT NULL,
   variant_form_id BIGINT NOT NULL
);

ALTER TABLE adaptation_type ADD CONSTRAINT uc_adaptation_type_name UNIQUE (name);

ALTER TABLE attestation ADD CONSTRAINT FK_ATTESTATION_ON_LOCATION FOREIGN KEY (location_id) REFERENCES location (location_id);
ALTER TABLE attestation ADD CONSTRAINT FK_ATTESTATION_ON_SOURCE_FINDING FOREIGN KEY (source_finding_id) REFERENCES source_finding (source_finding_id);
ALTER TABLE attestation ADD CONSTRAINT FK_ATTESTATION_ON_VARIANT_FORM FOREIGN KEY (variant_form_id) REFERENCES variant_form (variant_form_id);

ALTER TABLE language ADD CONSTRAINT uc_language_language_code UNIQUE (language_code);
ALTER TABLE language ADD CONSTRAINT uc_language_language_name UNIQUE (language_name);

ALTER TABLE locality_type ADD CONSTRAINT uc_locality_type_locality_type_name UNIQUE (locality_type_name);

ALTER TABLE location ADD CONSTRAINT FK_LOCATION_ON_DISTRICT_OR_PARISH FOREIGN KEY (district_or_parish_id) REFERENCES sub_region (sub_region_id);
ALTER TABLE location ADD CONSTRAINT FK_LOCATION_ON_LOCALITY_TYPE FOREIGN KEY (locality_type_id) REFERENCES locality_type (locality_type_id);

ALTER TABLE normalized_form ADD CONSTRAINT FK_NORMALIZED_FORM_ON_ETYMOLOGY_LANGUAGE FOREIGN KEY (etymology_language_id) REFERENCES language (language_id);
ALTER TABLE normalized_form ADD CONSTRAINT FK_NORMALIZED_FORM_ON_MEDIATING_LANGUAGE FOREIGN KEY (mediating_language_id) REFERENCES language (language_id);

ALTER TABLE part_of_source ADD CONSTRAINT uc_part_of_source_part_of_source_name UNIQUE (part_of_source_name);

ALTER TABLE region ADD CONSTRAINT uc_region_region_name UNIQUE (region_name);

ALTER TABLE source ADD CONSTRAINT FK_SOURCE_ON_LAND_SURVEYOR FOREIGN KEY (land_surveyor_id) REFERENCES land_surveyor (land_surveyor_id);
ALTER TABLE source ADD CONSTRAINT FK_SOURCE_ON_MAP_SIGNATURE FOREIGN KEY (map_signature_id) REFERENCES map_signature (map_signature_id);

ALTER TABLE source_finding ADD CONSTRAINT FK_SOURCE_FINDING_ON_PART_OF_SOURCE_TYPE FOREIGN KEY (part_of_source_type_id) REFERENCES part_of_source (part_of_source_id);
ALTER TABLE source_finding ADD CONSTRAINT FK_SOURCE_FINDING_ON_SOURCE FOREIGN KEY (source_id) REFERENCES source (source_id);

ALTER TABLE sub_region ADD CONSTRAINT FK_SUB_REGION_ON_BELONGS_TO_PRECINCT FOREIGN KEY (belongs_to_precinct_id) REFERENCES sub_region (sub_region_id);
ALTER TABLE sub_region ADD CONSTRAINT FK_SUB_REGION_ON_BELONGS_TO_REGION FOREIGN KEY (belongs_to_region_id) REFERENCES region (region_id);

ALTER TABLE variant_form ADD CONSTRAINT FK_VARIANT_FORM_ON_NORMALIZED_FORM FOREIGN KEY (normalized_form_id) REFERENCES normalized_form (normalized_form_id);

ALTER TABLE variant_to_adaptation_type_relation ADD CONSTRAINT fk_vartoadatyprel_on_adaptation_type FOREIGN KEY (adaptation_type_id) REFERENCES adaptation_type (adaptation_type_id);
ALTER TABLE variant_to_adaptation_type_relation ADD CONSTRAINT fk_vartoadatyprel_on_variant_form FOREIGN KEY (variant_form_id) REFERENCES variant_form (variant_form_id);
