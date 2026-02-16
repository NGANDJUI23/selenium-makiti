package api;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseApi {
    private static final String BASE_URL = "localhost:3000/";

    public static RequestSpecification requestSpecification(){
        return given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
    }
}
