package me.zenaro.validation.impl;

import static me.zenaro.validation.RegexValidationConstants.INVALID_CHARACTERES_REGEX;

import javax.inject.Singleton;

import me.zenaro.validation.RegexValidation;

@Singleton
public class InvalidCharacterValidation extends RegexValidation {

    public InvalidCharacterValidation() {
        super(INVALID_CHARACTERES_REGEX);
    }

    @Override
    public boolean validate(String value) {
        return !super.validate(value);
    }

}
