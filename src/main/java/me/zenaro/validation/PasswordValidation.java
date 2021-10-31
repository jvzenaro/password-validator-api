package me.zenaro.validation;

import java.util.List;

public class PasswordValidation implements IValidation<String> {

    private final List<IValidation<String>> validators;

    public PasswordValidation(final List<IValidation<String>> validators) {
        this.validators = validators;
    }

    public boolean validate(final String value) {
        return validators.stream().allMatch(validator -> validator.validate(value));
    }

}
