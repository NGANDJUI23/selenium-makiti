package trip;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseApiTripTest {
    private static final String BASE_URI = "https://dev.gateway.matoa.io/tms/tripplanningservice/v1";
    static Headers headers = new Headers(
            new Header("X-Request-ID", "d80f9b6a-c12f-4ec3-b572-5997c9d4ec56"),
            new Header("X-Application-ID", "0000-1_POSTMAN"),
            new Header("X-User-ID", "user-12345"),
            new Header("Accept", "application/json")
    );

    public static RequestSpecification requestSpecification() {
        return given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
//                .headers(headers)
                .param("travelDate", "2020-01-01");
    }
}
