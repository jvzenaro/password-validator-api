package me.zenaro.validator;

public class DuplicateCharacterValidation extends RegexValidation {

    private static final String DUPLICATED_CHAR_REGEX = "(.)\1{1,}";

    public DuplicateCharacterValidation() {
        super(DUPLICATED_CHAR_REGEX);
    }

    @Override
    public boolean validate(String value) {
        return !super.validate(value);
    }

}
