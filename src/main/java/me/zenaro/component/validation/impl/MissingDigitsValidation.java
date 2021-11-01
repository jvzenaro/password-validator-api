package me.zenaro.component.validation.impl;

import static me.zenaro.component.validation.RegexValidationConstants.DIGITS_REGEX;

import javax.inject.Singleton;

import me.zenaro.component.validation.RegexValidation;

@Singleton
public class MissingDigitsValidation extends RegexValidation {

    public MissingDigitsValidation() {
        super(DIGITS_REGEX);
    }

}
