package me.zenaro.domain.usecases.impl;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.smallrye.mutiny.Uni;
import me.zenaro.component.validation.impl.PasswordValidation;
import me.zenaro.domain.usecases.IPasswordValidationUseCase;

@ApplicationScoped
public class PasswordValidationUseCaseImpl implements IPasswordValidationUseCase {

    private final PasswordValidation passwordValidation;

    @Inject
    public PasswordValidationUseCaseImpl(final PasswordValidation passwordValidation) {
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
