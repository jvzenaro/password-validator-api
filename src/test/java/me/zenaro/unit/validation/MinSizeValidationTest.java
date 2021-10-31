package me.zenaro.unit.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.validation.MinSizeValidation;

public class MinSizeValidationTest {

    private final Integer minSize = 8;

    private final MinSizeValidation minSizeValidation = new MinSizeValidation(minSize);

    @CsvFileSource(resources = "/invalid_passwords_with_min_size.csv")
    @ParameterizedTest
    public void whenMinSizePasswordThenInvalid(final String password) {
        assertFalse(minSizeValidation.validate(password));
    }

    @CsvFileSource(resources = "/valid_passwords.csv")
    @ParameterizedTest
    public void whenNotMinSizePasswordThenValid(final String password) {
        assertTrue(minSizeValidation.validate(password));
    }

}
