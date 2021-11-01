package me.zenaro.component.validation;

import java.util.List;

public class ValidationComposite<T> implements IValidation<T> {

    private final List<IValidation<T>> validators;

    public ValidationComposite(final List<IValidation<T>> validators) {
        this.validators = validators;
    }

    public boolean validate(final T value) {
        return validators
                .stream()
                .allMatch(validator -> {
                    return validator
                            .validate(value);
                });
    }

}
