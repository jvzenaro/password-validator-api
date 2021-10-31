package me.zenaro.service;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.smallrye.mutiny.Uni;
import me.zenaro.usecases.IPasswordValidationUseCase;
import me.zenaro.validation.impl.PasswordValidation;

@Singleton
public class PasswordValidationUseCaseService implements IPasswordValidationUseCase {

    private final PasswordValidation passwordValidation;

    @Inject
    public PasswordValidationUseCaseService(final PasswordValidation passwordValidation) {
        this.passwordValidation = passwordValidation;
    }

    @Override
    public Uni<Boolean> validate(final String password) {
        return Uni
                .createFrom()
                .item(password)
                .map(passwordValidation::validate);
    }

}
