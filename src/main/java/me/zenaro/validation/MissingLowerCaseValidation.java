package me.zenaro.validation;

import static me.zenaro.validation.RegexValidationConstants.LOWER_CASE_REGEX;

public class MissingLowerCaseValidation extends RegexValidation {

    public MissingLowerCaseValidation() {
        super(LOWER_CASE_REGEX);
    }

}
