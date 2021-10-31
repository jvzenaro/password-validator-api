package me.zenaro.validator;

public class MissingCapitalLetterValidation extends RegexValidation {

    private static final String CAPITAL_LETTER_REGEX = "[A-Z]";

    public MissingCapitalLetterValidation() {
        super(CAPITAL_LETTER_REGEX);
    }

}
