package me.zenaro.validator;

import static me.zenaro.validator.RegexValidationConstants.CAPITAL_LETTER_REGEX;

public class MissingCapitalLetterValidation extends RegexValidation {

    public MissingCapitalLetterValidation() {
        super(CAPITAL_LETTER_REGEX);
    }

}
