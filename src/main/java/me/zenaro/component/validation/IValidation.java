package me.zenaro.component.validation;

public interface IValidation<T> {

    boolean validate(final T value);

}
