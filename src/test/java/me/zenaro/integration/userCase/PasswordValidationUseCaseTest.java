package me.zenaro.integration.userCase;

import javax.inject.Inject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import me.zenaro.usecases.IPasswordValidationUseCase;

@QuarkusTest
public class PasswordValidationUseCaseTest {

    private final IPasswordValidationUseCase passwordValidationUseCase;

    @Inject
    public PasswordValidationUseCaseTest(IPasswordValidationUseCase passwordValidationUseCase) {
        this.passwordValidationUseCase = passwordValidationUseCase;
    }

    @CsvFileSource(resources = { "/invalid_passwords_with_duplicate_character.csv",
            "/invalid_passwords_with_invalid_character.csv", "/invalid_passwords_with_max_size.csv",
            "/invalid_passwords_with_min_size.csv", "/invalid_passwords_with_missing_capital_letter.csv",
            "/invalid_passwords_with_missing_digit.csv", "/invalid_passwords_with_missing_lower_case.csv",
            "/invalid_passwords_with_missing_special_character.csv" })
    @ParameterizedTest
    public void whenInvalidPasswordThenReturnFalse(final String password) {
        passwordValidationUseCase
                .validate(password)
                .subscribe()
                .withSubscriber(UniAssertSubscriber
                        .create())
                .assertItem(false);
    }

    @CsvFileSource(resources = "/valid_passwords.csv")
    @ParameterizedTest
    public void whenValidPasswordThenReturnTrue(final String password) {
        passwordValidationUseCase
                .validate(password)
                .subscribe()
                .withSubscriber(UniAssertSubscriber
                        .create())
                .assertItem(true);
    }

}
