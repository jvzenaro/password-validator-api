package me.zenaro.validation;

import static me.zenaro.validation.RegexValidationConstants.CAPITAL_LETTER_REGEX;

public class MissingCapitalLetterValidation extends RegexValidation {

    public MissingCapitalLetterValidation() {
        super(CAPITAL_LETTER_REGEX);
    }

}
