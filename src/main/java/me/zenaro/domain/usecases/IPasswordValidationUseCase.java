package me.zenaro.domain.usecases;

import io.smallrye.mutiny.Uni;

public interface IPasswordValidationUseCase {

    public Uni<Boolean> validate(final String password);

}
