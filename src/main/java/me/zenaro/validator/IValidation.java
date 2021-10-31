package me.zenaro.validator;

public interface IValidation<T> {

    boolean validate(final T value);

}
