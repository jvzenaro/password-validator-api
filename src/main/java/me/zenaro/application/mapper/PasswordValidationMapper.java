package me.zenaro.application.mapper;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;

@ApplicationScoped
public class PasswordValidationMapper {

    public Response toResponse(final Boolean isValid) {
        if (isValid)
            return Response
                    .ok()
                    .build();
        return Response
                .status(Response.Status.BAD_REQUEST)
                .build();
    }

}
