ALTER TABLE normalized_form ALTER COLUMN morphological_name_type TYPE VARCHAR(255);

-- UPDATE VALUES ALREADY ADDED AS INT
-- **********************************
-- PHRASE 0
-- DERIVATION 1
-- SIMPLE 2
-- COMPOSITION 3
-- PLURAL 4
UPDATE normalized_form SET morphological_name_type = 'PHRASE' WHERE morphological_name_type = '0';
UPDATE normalized_form SET morphological_name_type = 'DERIVATION' WHERE morphological_name_type = '1';
UPDATE normalized_form SET morphological_name_type = 'SIMPLE' WHERE morphological_name_type = '2';
UPDATE normalized_form SET morphological_name_type = 'COMPOSITION' WHERE morphological_name_type = '3';
UPDATE normalized_form SET morphological_name_type = 'PLURAL' WHERE morphological_name_type = '4';

