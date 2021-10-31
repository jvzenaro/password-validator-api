package me.zenaro.validator;

public class MissingSpecialCharactersValidation extends RegexValidation {

    private static final String SPECIAL_CHARACTERES_REGEX = "[!@#$%^&*()-+]";

    public MissingSpecialCharactersValidation() {
        super(SPECIAL_CHARACTERES_REGEX);
    }

}
