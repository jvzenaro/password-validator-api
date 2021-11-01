package me.zenaro.application.mapper;

import javax.inject.Singleton;

import me.zenaro.application.controller.response.PasswordValidationResponse;

@Singleton
public class PasswordValidationMapper {

    public PasswordValidationResponse toResponse(final Boolean isValid) {
        return new PasswordValidationResponse(isValid);
    }

}
