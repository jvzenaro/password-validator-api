package me.zenaro.validator;

import static me.zenaro.validator.RegexValidationConstants.SPECIAL_CHARACTERES_REGEX;

public class MissingSpecialCharactersValidation extends RegexValidation {

    public MissingSpecialCharactersValidation() {
        super(SPECIAL_CHARACTERES_REGEX);
    }

}
