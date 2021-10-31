package me.zenaro.unit.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.validator.MissingDigitsValidation;

public class MissingDigitsValidationTest {

    private final MissingDigitsValidation missingDigitsValidation = new MissingDigitsValidation();

    @CsvFileSource(resources = "/invalid_passwords_with_missing_digit.csv")
    @ParameterizedTest
    public void whenWithoutDigitsInPasswordThenInvalid(final String password) {
        assertFalse(missingDigitsValidation.validate(password));
    }

    @CsvFileSource(resources = "/valid_passwords.csv")
    @ParameterizedTest
    public void whenHaveDigitsInPasswordThenValid(final String password) {
        assertTrue(missingDigitsValidation.validate(password));
    }

}
