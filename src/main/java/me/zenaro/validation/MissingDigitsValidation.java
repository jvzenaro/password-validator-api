package me.zenaro.validation;

import static me.zenaro.validation.RegexValidationConstants.DIGITS_REGEX;

public class MissingDigitsValidation extends RegexValidation {

    public MissingDigitsValidation() {
        super(DIGITS_REGEX);
    }

}
