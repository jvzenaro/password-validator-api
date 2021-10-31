package me.zenaro.usecases;

import io.smallrye.mutiny.Uni;

public interface IPasswordValidationUseCase {

    public Uni<Boolean> validate(String password);

}
