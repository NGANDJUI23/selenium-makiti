package api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;

public class UserApiTest {
    @ParameterizedTest
    @CsvSource({"users"})
    void shouldReturnCorrectStatutCode(){
        BaseApi.requestSpecification()
            .when()
                .get("users")
            .then()
                .statusCode(200);
    }

    @Test
    void shouldReturn404WhenUrlNotFound(){
        BaseApi.requestSpecification()
                .when()
                    .get("notfound")
                .then()
                    .statusCode(404);
    }
}
