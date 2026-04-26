import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest  {
    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnUnauthorizedWithValidToken() {
        String loginPayload = """
                {
                    "email": "testuser@example.com",
                    "password": "test1234"
                }
            """;

                // Arrange
        Response response = given()
            .contentType("application/json")
            .body(loginPayload)
            // Act
            .when()
            .post("/api/auth/login")
            // Assert
            .then()
            .statusCode(200)
            .body("token", notNullValue())
            // Extract response
            .extract()
            .response();

        System.out.println("Generated Token: " + response.jsonPath().getString("token"));
    }

    @Test
    public void shouldReturnUOnInvalidLogin() {
        String loginPayload = """
                {
                    "email": "invalidUser@example.com",
                    "password": "wrongPassword"
                }
            """;

        // Arrange
        given()
            .contentType("application/json")
            .body(loginPayload)
            // Act
            .when()
            .post("/api/auth/login")
            // Assert
            .then()
            .statusCode(401);
    }
}
