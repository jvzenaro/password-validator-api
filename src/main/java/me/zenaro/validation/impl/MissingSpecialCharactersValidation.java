package me.zenaro.validation.impl;

import static me.zenaro.validation.RegexValidationConstants.SPECIAL_CHARACTERES_REGEX;

import javax.inject.Singleton;

import me.zenaro.validation.RegexValidation;

@Singleton
public class MissingSpecialCharactersValidation extends RegexValidation {

    public MissingSpecialCharactersValidation() {
        super(SPECIAL_CHARACTERES_REGEX);
    }

}
