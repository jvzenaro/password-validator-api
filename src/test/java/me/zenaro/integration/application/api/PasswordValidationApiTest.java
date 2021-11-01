package me.zenaro.integration.application.api;

import static io.restassured.RestAssured.given;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_DUPLICATE;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_INVALID_CHAR;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MIN_SIZE;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_CAPITAL_LETTER;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_DIGIT;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_LOWER_CASE;
import static me.zenaro.FileTestPath.INVALID_PASSWORDS_MISSING_SPECIAL_CHAR;
import static me.zenaro.FileTestPath.VALID_PASSWORDS;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PasswordValidationApiTest {

        @CsvFileSource(resources = { INVALID_PASSWORDS_DUPLICATE, INVALID_PASSWORDS_INVALID_CHAR,
                        INVALID_PASSWORDS_MIN_SIZE, INVALID_PASSWORDS_MISSING_CAPITAL_LETTER,
                        INVALID_PASSWORDS_MISSING_DIGIT, INVALID_PASSWORDS_MISSING_LOWER_CASE,
                        INVALID_PASSWORDS_MISSING_SPECIAL_CHAR })
        @ParameterizedTest
        public void whenInvalidPasswordThenReturnFalse(final String password) {
                given()
                                .when()
                                .body(password)
                                .post("/password/validation")
                                .then()
                                .statusCode(200)
                                .body("valid", equalTo(false));
        }

        @CsvFileSource(resources = VALID_PASSWORDS)
        @ParameterizedTest
        public void whenValidPasswordThenReturnTrue(final String password) {
                given()
                                .when()
                                .body(password)
                                .post("/password/validation")
                                .then()
                                .statusCode(200)
                                .body("valid", equalTo(true));
        }

        @Test
        public void whenPasswordThenReturnFalse() {
                given()
                                .when()
                                .post("/password/validation")
                                .then()
                                .statusCode(200)
                                .body("valid", equalTo(false));
        }

}
