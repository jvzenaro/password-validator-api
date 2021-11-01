package me.zenaro.application.controller;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import io.smallrye.mutiny.Uni;
import me.zenaro.application.gateway.inbound.IPasswordValidationGateway;
import me.zenaro.application.mapper.PasswordValidationMapper;
import me.zenaro.domain.usecases.IPasswordValidationUseCase;

@Path("/password/validation")
public class PasswordValidationApiController implements IPasswordValidationGateway {

    private final IPasswordValidationUseCase passwordValidationUseCase;
    private final PasswordValidationMapper passwordValidationResponseMapper;

    @Inject
    public PasswordValidationApiController(final IPasswordValidationUseCase passwordValidationUseCase,
            final PasswordValidationMapper passwordValidationResponseMapper) {
        this.passwordValidationUseCase = passwordValidationUseCase;
        this.passwordValidationResponseMapper = passwordValidationResponseMapper;
    }

    @Override
    @POST
    public Uni<Response> validate(final String password) {
        return passwordValidationUseCase
                .validate(password)
                .map(passwordValidationResponseMapper::toResponse);
    }

}
