package me.zenaro.unit.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.validation.impl.DuplicateCharacterValidation;

public class DuplicateCharacterValidationTest {

    private final DuplicateCharacterValidation duplicateCharacterValidation = new DuplicateCharacterValidation();

    @CsvFileSource(resources = "/invalid_passwords_with_duplicate_character.csv")
    @ParameterizedTest
    public void whenDuplicateCharacterThenInvalid(final String password) {
        assertFalse(duplicateCharacterValidation.validate(password));
    }

    @CsvFileSource(resources = "/valid_passwords.csv")
    @ParameterizedTest
    public void whenNotDuplicateCharacterThenValid(final String password) {
        assertTrue(duplicateCharacterValidation.validate(password));
    }

}
