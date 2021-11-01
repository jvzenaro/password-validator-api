package me.zenaro.integration.api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class PasswordValidationApiTest {

        @CsvFileSource(resources = { "/invalid_passwords_with_duplicate_character.csv",
                        "/invalid_passwords_with_invalid_character.csv", "/invalid_passwords_with_min_size.csv",
                        "/invalid_passwords_with_missing_capital_letter.csv",
                        "/invalid_passwords_with_missing_digit.csv", "/invalid_passwords_with_missing_lower_case.csv",
                        "/invalid_passwords_with_missing_special_character.csv" })
        @ParameterizedTest
        public void whenInvalidPasswordThenReturnFalse(final String password) {
                given()
                                .when()
                                .body(password)
                                .post("/password/validation")
                                .then()
                                .statusCode(400);
        }

        @CsvFileSource(resources = "/valid_passwords.csv")
        @ParameterizedTest
        public void whenValidPasswordThenReturnTrue(final String password) {
                given()
                                .when()
                                .body(password)
                                .post("/password/validation")
                                .then()
                                .statusCode(200);
        }

}
