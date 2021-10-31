package me.zenaro.unit.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.validator.MissingCapitalLetterValidation;
import me.zenaro.validator.MissingSpecialCharactersValidation;

public class MissingCapitalLetterValidationTest {

    private final MissingCapitalLetterValidation missingCapitalLetterValidation = new MissingCapitalLetterValidation();

    @CsvFileSource(resources = "/invalid_passwords_with_missing_capital_letter.csv")
    @ParameterizedTest
    public void whenWithoutCapitalLetterInPasswordThenInvalid(final String password) {
        assertFalse(missingCapitalLetterValidation.validate(password));
    }

    @CsvFileSource(resources = "/valid_passwords.csv")
    @ParameterizedTest
    public void whenHaveCapitalLetterInPasswordThenValid(final String password) {
        assertTrue(missingCapitalLetterValidation.validate(password));
    }

}
