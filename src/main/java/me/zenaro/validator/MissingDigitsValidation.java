package me.zenaro.validator;

import static me.zenaro.validator.RegexValidationConstants.DIGITS_REGEX;

public class MissingDigitsValidation extends RegexValidation {

    public MissingDigitsValidation() {
        super(DIGITS_REGEX);
    }

}
