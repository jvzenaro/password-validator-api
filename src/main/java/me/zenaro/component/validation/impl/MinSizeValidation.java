package me.zenaro.component.validation.impl;

import static java.util.Optional.ofNullable;

import javax.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import me.zenaro.component.validation.IValidation;

@Singleton
public class MinSizeValidation implements IValidation<String> {

    private final Integer minSize;

    public MinSizeValidation(@ConfigProperty(name = "validator.size.min") final Integer minSize) {
        this.minSize = minSize;
    }

    public boolean validate(final String value) {
        return ofNullable(value)
                .filter(v -> v
                        .length() >= minSize)
                .isPresent();
    }

}
