package me.zenaro.application.gateway.inbound;

import io.smallrye.mutiny.Uni;
import me.zenaro.application.controller.response.PasswordValidationResponse;

public interface IPasswordValidationInboud {

    public Uni<PasswordValidationResponse> validate(final String password);

}
