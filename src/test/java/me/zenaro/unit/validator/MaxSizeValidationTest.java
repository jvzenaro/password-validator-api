package me.zenaro.unit.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import me.zenaro.validator.MaxSizeValidation;

public class MaxSizeValidationTest {

    private final Integer maxSize = 16;

    private final MaxSizeValidation maxSizeValidation = new MaxSizeValidation(maxSize);

    @CsvFileSource(resources = "/invalid_passwords_with_max_size.csv")
    @ParameterizedTest
    public void whenDuplicateCharacterThenInvalid(final String password) {
        assertFalse(maxSizeValidation.validate(password));
    }

    @CsvFileSource(resources = "/valid_passwords.csv")
    @ParameterizedTest
    public void whenNotDuplicateCharacterThenValid(final String password) {
        assertTrue(maxSizeValidation.validate(password));
    }

}
