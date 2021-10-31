package me.zenaro.validation.impl;

import static me.zenaro.validation.RegexValidationConstants.LOWER_CASE_REGEX;

import javax.inject.Singleton;

import me.zenaro.validation.RegexValidation;

@Singleton
public class MissingLowerCaseValidation extends RegexValidation {

    public MissingLowerCaseValidation() {
        super(LOWER_CASE_REGEX);
    }

}
