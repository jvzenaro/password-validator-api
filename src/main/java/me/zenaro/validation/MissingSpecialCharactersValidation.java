package me.zenaro.validation;

import static me.zenaro.validation.RegexValidationConstants.SPECIAL_CHARACTERES_REGEX;

public class MissingSpecialCharactersValidation extends RegexValidation {

    public MissingSpecialCharactersValidation() {
        super(SPECIAL_CHARACTERES_REGEX);
    }

}
