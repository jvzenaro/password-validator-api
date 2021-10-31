package me.zenaro.validation.impl;

import static me.zenaro.validation.RegexValidationConstants.CAPITAL_LETTER_REGEX;

import javax.inject.Singleton;

import me.zenaro.validation.RegexValidation;

@Singleton
public class MissingCapitalLetterValidation extends RegexValidation {

    public MissingCapitalLetterValidation() {
        super(CAPITAL_LETTER_REGEX);
    }

}
