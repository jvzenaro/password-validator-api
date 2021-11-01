package me.zenaro.integration.domain.userCase;

import static me.zenaro.FileTestPath.INVALID_PASSWORDS_DUPLICATE;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_INVALID_CHAR;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MIN_SIZE;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_CAPITAL_LETTER;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_DIGIT;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_LOWER_CASE;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_SPECIAL_CHAR;
import static me.zenaro.FileTestPath.VALID_PASSWORDS;

import javax.inject.Inject;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.helpers.test.UniAssertSubscriber;
import me.zenaro.domain.usecases.IPasswordValidationUseCase;

@QuarkusTest
public class PasswordValidationUseCaseTest {

        private final IPasswordValidationUseCase passwordValidationUseCase;

        @Inject
        public PasswordValidationUseCaseTest(IPasswordValidationUseCase passwordValidationUseCase) {
                this.passwordValidationUseCase = passwordValidationUseCase;
        }

        @CsvFileSource(resources = { INVALID_PASSWORDS_DUPLICATE, INVALID_PASSWORDS_INVALID_CHAR,
                        INVALID_PASSWORDS_MIN_SIZE, INVALID_PASSWORDS_MISSING_CAPITAL_LETTER,
                        INVALID_PASSWORDS_MISSING_DIGIT, INVALID_PASSWORDS_MISSING_LOWER_CASE,
                        INVALID_PASSWORDS_MISSING_SPECIAL_CHAR })
        @ParameterizedTest
        public void whenInvalidPasswordThenReturnFalse(final String password) {
                passwordValidationUseCase
                                .validate(password)
                                .subscribe()
                                .withSubscriber(UniAssertSubscriber
                                                .create())
                                .assertItem(false);
        }

        @CsvFileSource(resources = VALID_PASSWORDS)
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
