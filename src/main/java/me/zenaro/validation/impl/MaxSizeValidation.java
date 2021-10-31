package me.zenaro.validation.impl;

import javax.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import me.zenaro.validation.IValidation;

@Singleton
public class MaxSizeValidation implements IValidation<String> {

    private final Integer maxSize;

    public MaxSizeValidation(@ConfigProperty(name = "validator.size.max") final Integer maxSize) {
        this.maxSize = maxSize;
    }

    public boolean validate(final String value) {
        return value != null && value
                .length() <= maxSize;
    }

}
