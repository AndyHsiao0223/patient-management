import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class PatientIntegrationTest {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnPatientsWithValidToken() {
        String loginPayload = """
                {
                    "email": "testuser@example.com",
                    "password": "test1234"
                }
            """;

            // Arrange
        String token = given()
            .contentType("application/json")
            .body(loginPayload)
            // Act
            .when()
            .post("/api/auth/login")
            // Assert
            .then()
            .statusCode(200)
            // Extract response
            .extract()
            .jsonPath()
            .get("token");

        given()
            .header("Authorization", "Bearer " + token)
            .when()
            .get("/api/patients")
            .then()
            .statusCode(200)
            .body("patients", notNullValue());
    }
}
