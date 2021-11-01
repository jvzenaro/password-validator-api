package me.zenaro.application.controller;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import io.smallrye.mutiny.Uni;
import me.zenaro.application.controller.response.PasswordValidationResponse;
import me.zenaro.application.gateway.inbound.IPasswordValidationInboud;
import me.zenaro.application.mapper.PasswordValidationMapper;
import me.zenaro.domain.usecases.IPasswordValidationUseCase;

@Path("/password/validation")
public class PasswordValidationController implements IPasswordValidationInboud {

    private final IPasswordValidationUseCase passwordValidationUseCase;
    private final PasswordValidationMapper passwordValidationResponseMapper;

    @Inject
    public PasswordValidationController(final IPasswordValidationUseCase passwordValidationUseCase,
            final PasswordValidationMapper passwordValidationResponseMapper) {
        this.passwordValidationUseCase = passwordValidationUseCase;
        this.passwordValidationResponseMapper = passwordValidationResponseMapper;
    }

    @Override
    @POST
    public Uni<PasswordValidationResponse> validate(final String password) {
        return passwordValidationUseCase
                .validate(password)
                .map(passwordValidationResponseMapper::toResponse);
    }

}
