package me.zenaro.validator;

import javax.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Singleton
public class MaxSizeValidation implements IValidation<String> {

    private final Integer maxSize;

    public MaxSizeValidation(@ConfigProperty(name = "validator.size.max") final Integer maxSize) {
        this.maxSize = maxSize;
    }

    public boolean validate(final String value) {
        return value != null && value.length() <= maxSize;
    }

}
