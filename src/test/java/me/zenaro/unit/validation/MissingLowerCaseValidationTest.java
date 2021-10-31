package me.zenaro.unit.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.validation.impl.MissingLowerCaseValidation;

public class MissingLowerCaseValidationTest {

    private final MissingLowerCaseValidation missingLowerCaseValidation = new MissingLowerCaseValidation();

    @CsvFileSource(resources = "/invalid_passwords_with_missing_lower_case.csv")
    @ParameterizedTest
    public void whenWithoutLowerCaseInPasswordThenInvalid(final String password) {
        assertFalse(missingLowerCaseValidation
                .validate(password));
    }

    @CsvFileSource(resources = "/valid_passwords.csv")
    @ParameterizedTest
    public void whenHaveLowerCaseInPasswordThenValid(final String password) {
        assertTrue(missingLowerCaseValidation
                .validate(password));
    }

}
