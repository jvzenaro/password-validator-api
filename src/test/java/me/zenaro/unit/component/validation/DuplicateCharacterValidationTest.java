package me.zenaro.unit.component.validation;

import static me.zenaro.FileTestPath.INVALID_PASSWORDS_DUPLICATE;
import static me.zenaro.FileTestPath.VALID_PASSWORDS;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.component.validation.impl.DuplicateCharacterValidation;

public class DuplicateCharacterValidationTest {

    private final DuplicateCharacterValidation duplicateCharacterValidation = new DuplicateCharacterValidation();

    @CsvFileSource(resources = INVALID_PASSWORDS_DUPLICATE)
    @ParameterizedTest
    public void whenDuplicateCharacterThenInvalid(final String password) {
        assertFalse(duplicateCharacterValidation
                .validate(password));
    }

    @CsvFileSource(resources = VALID_PASSWORDS)
    @ParameterizedTest
    public void whenNotDuplicateCharacterThenValid(final String password) {
        assertTrue(duplicateCharacterValidation
                .validate(password));
    }

}
