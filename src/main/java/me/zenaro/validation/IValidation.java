package me.zenaro.validation;

public interface IValidation<T> {

    boolean validate(final T value);

}
