package me.zenaro.unit.component.validation;

import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MIN_SIZE;
import static me.zenaro.FileTestPath.VALID_PASSWORDS;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.component.validation.impl.MinSizeValidation;

public class MinSizeValidationTest {

    private final Integer minSize = 9;

    private final MinSizeValidation minSizeValidation = new MinSizeValidation(minSize);

    @CsvFileSource(resources = INVALID_PASSWORDS_MIN_SIZE)
    @ParameterizedTest
    public void whenMinSizePasswordThenInvalid(final String password) {
        assertFalse(minSizeValidation
                .validate(password));
    }

    @CsvFileSource(resources = VALID_PASSWORDS)
    @ParameterizedTest
    public void whenNotMinSizePasswordThenValid(final String password) {
        assertTrue(minSizeValidation
                .validate(password));
    }
}
