create sequence if not exists hibernate_sequence start 1 increment 1;

create table adaptation_type (
   adaptation_type_id int8 not null,
    name varchar(255) not null,
    primary key (adaptation_type_id)
);

create table attestation (
   attestation_id int8 not null,
    notes TEXT,
    original_form varchar(255) not null,
    location_id int8,
    source_finding_id int8,
    variant_form_id int8,
    primary key (attestation_id)
);

create table land_surveyor (
   land_surveyor_id int8 not null,
    name varchar(255),
    primary key (land_surveyor_id)
);

create table language (
   language_id int8 not null,
    language_code varchar(255) not null,
    language_name varchar(255) not null,
    primary key (language_id)
);

create table locality_type (
   locality_type_id int8 not null,
    locality_type_name varchar(255) not null,
    primary key (locality_type_id)
);

create table location (
   location_id int8 not null,
    latitude float8,
    longitude float8,
    modern_lookup_form varchar(255),
    district_or_parish_id int8,
    locality_type_id int8,
    primary key (location_id)
);

create table map_signature (
   map_signature_id int8 not null,
    map_signature varchar(255),
    primary key (map_signature_id)
);

create table normalized_form (
   normalized_form_id int8 not null,
    comparative_form_information TEXT,
    derivation_base varchar(255),
    derivation_morpheme varchar(255),
    determination_clause_in_composition varchar(255),
    determination_clause_in_phrase varchar(255),
    joint_morpheme_in_composition varchar(255),
    main_clause_in_composition varchar(255),
    main_clause_in_phrase varchar(255),
    simple_root_morpheme varchar(255),
    morphological_name_type int4,
    morphological_name_type_is_shaky boolean,
    normalized_form varchar(255),
    etymology_language_id int8,
    mediating_language_id int8,
    primary key (normalized_form_id)
);

create table part_of_source (
   part_of_source_id int8 not null,
    part_of_source_name varchar(255) not null,
    primary key (part_of_source_id)
);

create table region (
   region_id int8 not null,
    region_name varchar(255) not null,
    primary key (region_id)
);

create table source (
   dtype varchar(31) not null,
    source_id int8 not null,
    dating DATE,
    map_sheet int4,
    name varchar(255),
    page int4,
    sub_section varchar(255),
    land_surveyor_id int8,
    map_signature_id int8,
    primary key (source_id)
);

create table source_finding (
   source_finding_id int8 not null,
    part_of_source_type_id int8,
    source_id int8,
    primary key (source_finding_id)
);

create table sub_region (
   dtype varchar(31) not null,
    sub_region_id int8 not null,
    name varchar(255),
    belongs_to_region_id int8,
    belongs_to_precinct_id int8,
    primary key (sub_region_id)
);

create table variant_form (
   variant_form_id int8 not null,
    is_adapted_to_swedish int4,
    variant_form varchar(255),
    normalized_form_id int8,
    primary key (variant_form_id)
);

create table variant_to_adaptation_type_relation (
   variant_form_id int8 not null,
    adaptation_type_id int8 not null
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
