package me.zenaro.validation.impl;

import static me.zenaro.validation.RegexValidationConstants.DIGITS_REGEX;

import javax.inject.Singleton;

import me.zenaro.validation.RegexValidation;

@Singleton
public class MissingDigitsValidation extends RegexValidation {

    public MissingDigitsValidation() {
        super(DIGITS_REGEX);
    }

}
