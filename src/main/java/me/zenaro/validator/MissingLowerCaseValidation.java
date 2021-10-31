package me.zenaro.validator;

public class MissingLowerCaseValidation extends RegexValidation {

    private static final String LOWER_CASE_REGEX = "[a-z]";

    public MissingLowerCaseValidation() {
        super(LOWER_CASE_REGEX);
    }

}
