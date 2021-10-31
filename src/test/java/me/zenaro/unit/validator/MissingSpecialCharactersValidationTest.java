package me.zenaro.unit.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.validator.MissingSpecialCharactersValidation;

public class MissingSpecialCharactersValidationTest {

    private final MissingSpecialCharactersValidation missingSpecialCharactersValidation = new MissingSpecialCharactersValidation();

    @CsvFileSource(resources = "/invalid_passwords_with_missing_special_character.csv")
    @ParameterizedTest
    public void whenWithoutSpecialCharactersInPasswordThenInvalid(final String password) {
        assertFalse(missingSpecialCharactersValidation.validate(password));
    }

    @CsvFileSource(resources = "/valid_passwords.csv")
    @ParameterizedTest
    public void whenHaveSpecialCharactersInPasswordThenValid(final String password) {
        assertTrue(missingSpecialCharactersValidation.validate(password));
    }

}
