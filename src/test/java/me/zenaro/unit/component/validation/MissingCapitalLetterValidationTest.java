package me.zenaro.unit.component.validation;

import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_CAPITAL_LETTER;
import static me.zenaro.FileTestPath.VALID_PASSWORDS;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.component.validation.impl.MissingCapitalLetterValidation;

public class MissingCapitalLetterValidationTest {

    private final MissingCapitalLetterValidation missingCapitalLetterValidation = new MissingCapitalLetterValidation();

    @CsvFileSource(resources = INVALID_PASSWORDS_MISSING_CAPITAL_LETTER)
    @ParameterizedTest
    public void whenWithoutCapitalLetterInPasswordThenInvalid(final String password) {
        assertFalse(missingCapitalLetterValidation
                .validate(password));
    }

    @CsvFileSource(resources = VALID_PASSWORDS)
    @ParameterizedTest
    public void whenHaveCapitalLetterInPasswordThenValid(final String password) {
        assertTrue(missingCapitalLetterValidation
                .validate(password));
    }

}
