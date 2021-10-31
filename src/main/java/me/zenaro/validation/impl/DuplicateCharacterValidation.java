package me.zenaro.validation.impl;

import javax.inject.Singleton;

import me.zenaro.validation.IValidation;

@Singleton
public class DuplicateCharacterValidation implements IValidation<String> {

    @Override
    public boolean validate(String value) {
        return value.length() == value.chars().distinct().count();
    }

}
