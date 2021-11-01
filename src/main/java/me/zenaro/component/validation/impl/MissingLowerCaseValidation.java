package me.zenaro.component.validation.impl;

import static me.zenaro.component.validation.RegexValidationConstants.LOWER_CASE_REGEX;

import javax.inject.Singleton;

import me.zenaro.component.validation.RegexValidation;

@Singleton
public class MissingLowerCaseValidation extends RegexValidation {

    public MissingLowerCaseValidation() {
        super(LOWER_CASE_REGEX);
    }

}
