package me.zenaro.component.validation.impl;

import static me.zenaro.component.validation.RegexValidationConstants.SPECIAL_CHARACTERES_REGEX;

import javax.inject.Singleton;

import me.zenaro.component.validation.RegexValidation;

@Singleton
public class MissingSpecialCharactersValidation extends RegexValidation {

    public MissingSpecialCharactersValidation() {
        super(SPECIAL_CHARACTERES_REGEX);
    }

}
