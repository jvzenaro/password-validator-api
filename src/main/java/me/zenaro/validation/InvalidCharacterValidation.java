package me.zenaro.validation;

import static me.zenaro.validation.RegexValidationConstants.INVALID_CHARACTERES_REGEX;

public class InvalidCharacterValidation extends RegexValidation {

    public InvalidCharacterValidation() {
        super(INVALID_CHARACTERES_REGEX);
    }

    @Override
    public boolean validate(String value) {
        return !super.validate(value);
    }

}
