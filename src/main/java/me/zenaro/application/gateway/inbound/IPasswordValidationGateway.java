package me.zenaro.application.gateway.inbound;

import javax.ws.rs.core.Response;

import io.smallrye.mutiny.Uni;

public interface IPasswordValidationGateway {

    public Uni<Response> validate(final String password);

}
