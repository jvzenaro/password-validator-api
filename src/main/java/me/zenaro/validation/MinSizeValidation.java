package me.zenaro.validation;

import javax.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Singleton
public class MinSizeValidation implements IValidation<String> {

    private final Integer minSize;

    public MinSizeValidation(@ConfigProperty(name = "validator.size.min") final Integer minSize) {
        this.minSize = minSize;
    }

    public boolean validate(final String value) {
        return value != null && value.length() >= minSize;
    }

}
