ALTER TABLE variant_form ALTER COLUMN is_adapted_to_swedish TYPE VARCHAR(255);

-- UPDATE VALUES ALREADY ADDED AS INT
-- **********************************
-- YES
-- PROBABLY_YES
-- NO
-- PROBABLY_NO
UPDATE variant_form SET is_adapted_to_swedish = 'YES' WHERE is_adapted_to_swedish = '0';
UPDATE variant_form SET is_adapted_to_swedish = 'PROBABLY_YES' WHERE is_adapted_to_swedish = '1';
UPDATE variant_form SET is_adapted_to_swedish = 'NO' WHERE is_adapted_to_swedish = '2';
UPDATE variant_form SET is_adapted_to_swedish = 'PROBABLY_NO' WHERE is_adapted_to_swedish = '3';