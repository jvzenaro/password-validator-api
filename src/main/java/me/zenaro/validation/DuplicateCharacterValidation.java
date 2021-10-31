package me.zenaro.validation;

public class DuplicateCharacterValidation implements IValidation<String> {

    @Override
    public boolean validate(String value) {
        return value.length() == value.chars().distinct().count();
    }

}
