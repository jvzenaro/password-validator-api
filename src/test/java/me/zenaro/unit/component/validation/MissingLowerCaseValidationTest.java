package me.zenaro.unit.component.validation;

import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_LOWER_CASE;
import static me.zenaro.FileTestPath.VALID_PASSWORDS;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.component.validation.impl.MissingLowerCaseValidation;

public class MissingLowerCaseValidationTest {

    private final MissingLowerCaseValidation missingLowerCaseValidation = new MissingLowerCaseValidation();

    @CsvFileSource(resources = INVALID_PASSWORDS_MISSING_LOWER_CASE)
    @ParameterizedTest
    public void whenWithoutLowerCaseInPasswordThenInvalid(final String password) {
        assertFalse(missingLowerCaseValidation
                .validate(password));
    }

    @CsvFileSource(resources = VALID_PASSWORDS)
    @ParameterizedTest
    public void whenHaveLowerCaseInPasswordThenValid(final String password) {
        assertTrue(missingLowerCaseValidation
                .validate(password));
    }

}
