package me.zenaro.validation.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import me.zenaro.validation.IValidation;

@Singleton
public class PasswordValidation implements IValidation<String> {

    private final List<IValidation<String>> validators;

    @Inject
    public PasswordValidation(@Named("passwordValidation") final List<IValidation<String>> validators) {
        this.validators = validators;
    }

    public boolean validate(final String value) {
        return validators.stream().allMatch(validator -> {
            return validator.validate(value);
        });
    }

}
