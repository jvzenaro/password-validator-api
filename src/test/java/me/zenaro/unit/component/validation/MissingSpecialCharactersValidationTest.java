package me.zenaro.unit.component.validation;

import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_SPECIAL_CHAR;
import static me.zenaro.FileTestPath.VALID_PASSWORDS;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.component.validation.impl.MissingSpecialCharactersValidation;

public class MissingSpecialCharactersValidationTest {

    private final MissingSpecialCharactersValidation missingSpecialCharactersValidation = new MissingSpecialCharactersValidation();

    @CsvFileSource(resources = INVALID_PASSWORDS_MISSING_SPECIAL_CHAR)
    @ParameterizedTest
    public void whenWithoutSpecialCharactersInPasswordThenInvalid(final String password) {
        assertFalse(missingSpecialCharactersValidation
                .validate(password));
    }

    @CsvFileSource(resources = VALID_PASSWORDS)
    @ParameterizedTest
    public void whenHaveSpecialCharactersInPasswordThenValid(final String password) {
        assertTrue(missingSpecialCharactersValidation
                .validate(password));
    }

}
