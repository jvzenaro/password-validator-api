package me.zenaro.component.validation.impl;

import javax.inject.Singleton;

import me.zenaro.component.validation.IValidation;

@Singleton
public class DuplicateCharacterValidation implements IValidation<String> {

    @Override
    public boolean validate(final String value) {
        return value
                .length() == value
                        .chars()
                        .distinct()
                        .count();
    }

}
