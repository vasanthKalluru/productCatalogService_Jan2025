ALTER TABLE test_model
DROP
COLUMN number_field;

ALTER TABLE st_user
    MODIFY ratings DOUBLE NOT NULL;

ALTER TABLE st_user
    MODIFY user_type INT NULL;