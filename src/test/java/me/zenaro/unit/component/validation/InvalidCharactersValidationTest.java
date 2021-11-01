package me.zenaro.unit.component.validation;

import static me.zenaro.FileTestPath.INVALID_PASSWORDS_INVALID_CHAR;
import static me.zenaro.FileTestPath.VALID_PASSWORDS;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.component.validation.impl.InvalidCharacterValidation;

public class InvalidCharactersValidationTest {

    private final InvalidCharacterValidation invalidCharacterValidation = new InvalidCharacterValidation();

    @CsvFileSource(resources = INVALID_PASSWORDS_INVALID_CHAR)
    @ParameterizedTest
    public void whenInvalidCharacterThenInvalid(final String password) {
        assertFalse(invalidCharacterValidation
                .validate(password));
    }

    @CsvFileSource(resources = VALID_PASSWORDS)
    @ParameterizedTest
    public void whenNotInvalidCharacterThenValid(final String password) {
        assertTrue(invalidCharacterValidation
                .validate(password));
    }

}
