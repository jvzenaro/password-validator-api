package me.zenaro.component.validation.impl;

import static me.zenaro.component.validation.RegexValidationConstants.INVALID_CHARACTERES_REGEX;

import javax.inject.Singleton;

import me.zenaro.component.validation.RegexValidation;

@Singleton
public class InvalidCharacterValidation extends RegexValidation {

    public InvalidCharacterValidation() {
        super(INVALID_CHARACTERES_REGEX);
    }

    @Override
    public boolean validate(final String value) {
        return !super.validate(value);
    }

}
