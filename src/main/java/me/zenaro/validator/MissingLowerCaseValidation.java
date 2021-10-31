package me.zenaro.validator;

import static me.zenaro.validator.RegexValidationConstants.LOWER_CASE_REGEX;

public class MissingLowerCaseValidation extends RegexValidation {

    public MissingLowerCaseValidation() {
        super(LOWER_CASE_REGEX);
    }

}
