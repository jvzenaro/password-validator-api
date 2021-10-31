package me.zenaro.validator;

public class MissingDigitsValidation extends RegexValidation {

    private static final String DIGITS_REGEX = "[0-9]";

    public MissingDigitsValidation() {
        super(DIGITS_REGEX);
    }

}
