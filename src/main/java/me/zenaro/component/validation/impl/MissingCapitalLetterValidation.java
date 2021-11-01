package me.zenaro.component.validation.impl;

import static me.zenaro.component.validation.RegexValidationConstants.CAPITAL_LETTER_REGEX;

import javax.inject.Singleton;

import me.zenaro.component.validation.RegexValidation;

@Singleton
public class MissingCapitalLetterValidation extends RegexValidation {

    public MissingCapitalLetterValidation() {
        super(CAPITAL_LETTER_REGEX);
    }

}
