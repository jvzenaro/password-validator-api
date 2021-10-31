package me.zenaro.unit.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.validator.InvalidCharacterValidation;

public class InvalidCharactersValidationTest {

    private final InvalidCharacterValidation invalidCharacterValidation = new InvalidCharacterValidation();

    @CsvFileSource(resources = "/invalid_passwords_with_invalid_character.csv")
    @ParameterizedTest
    public void whenInvalidCharacterThenInvalid(final String password) {
        assertFalse(invalidCharacterValidation.validate(password));
    }

    @CsvFileSource(resources = "/valid_passwords.csv")
    @ParameterizedTest
    public void whenNotInvalidCharacterThenValid(final String password) {
        assertTrue(invalidCharacterValidation.validate(password));
    }

}
