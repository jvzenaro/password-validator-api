package me.zenaro.unit.component.validation;

import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_DIGIT;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.FileTestPath;
import me.zenaro.component.validation.impl.MissingDigitsValidation;

public class MissingDigitsValidationTest {

    private final MissingDigitsValidation missingDigitsValidation = new MissingDigitsValidation();

    @CsvFileSource(resources = INVALID_PASSWORDS_MISSING_DIGIT)
    @ParameterizedTest
    public void whenWithoutDigitsInPasswordThenInvalid(final String password) {
        assertFalse(missingDigitsValidation
                .validate(password));
    }

    @CsvFileSource(resources = FileTestPath.VALID_PASSWORDS)
    @ParameterizedTest
    public void whenHaveDigitsInPasswordThenValid(final String password) {
        assertTrue(missingDigitsValidation
                .validate(password));
    }

}
