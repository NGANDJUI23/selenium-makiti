package trip;

import org.junit.jupiter.api.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

public class TripTest {
    Header tokenHeader = new Header("Authorization", "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJPMnFsYnNXcmVWRGRtdk1PNFN5UENUdlVoYWMzT1ZYMUFSLThSUWttMGZRIn0.eyJleHAiOjE3NzA2NTA3MDUsImlhdCI6MTc3MDY0MzUwNSwiYXV0aF90aW1lIjoxNzcwNjQzNDYzLCJqdGkiOiI2NzE1ZjQ0MC01NDY4LTQ5YTItODhkMC1iOGFiODE3MjIxZmQiLCJpc3MiOiJodHRwczovL2RldjEuaWRlbnRpdHkubWFraXRpLWdyb3VwLmNvbS9yZWFsbXMvdG1zIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjY5MjIxM2U2LWVlZWItNGE4ZC1iZGZmLTU3MDdhNjE2ZGM5ZiIsInR5cCI6IkJlYXJlciIsImF6cCI6IjEyNDMtM19NVkFXUCIsInNpZCI6ImFiNzdhZDQzLTg3ZGYtNDQ1Ni05NGNlLWU3NjI4ZWEyYTg0ZSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL2xvY2FsaG9zdDozMDA1IiwiaHR0cHM6Ly9kZXYuYWRtaW4ubWF0b2EuaW8iLCJodHRwczovL3d3dy5kZXYuYWRtaW4ubWF0b2EuaW8iXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtdG1zIiwib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7IjEyNDMtM19NVkFXUCI6eyJyb2xlcyI6WyIxMjQzLTNfTVZBV1A6OnN1cGVyLWFkbWluIl19LCJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImJyYW5kOnJlYWQ6b25lIG1vZGVsOnJlYWQ6YWxsIHByb2ZpbGUgYnVzOmNyZWF0ZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJuYW1lIjoiQWRtaW4gMDA3IiwicHJlZmVycmVkX3VzZXJuYW1lIjoiYWRtaW4wMDciLCJnaXZlbl9uYW1lIjoiQWRtaW4iLCJsb2NhbGUiOiJlbiIsImZhbWlseV9uYW1lIjoiMDA3IiwiZW1haWwiOiJhZG1pbjAwN0BtYWtpdGkuZGUifQ.R7PoDHVE9fCV1fIeCpZIAV7nul3d1_9PjAsiWNqq55EVigqYeUDcdxjrTl6AcdXN8Z2JP5TRvQJn0XqP88ctxsnwPp_9vda7fWlySCmcpGwzhWtr1NwP6UH0mDKK9A5EE4kAEHYyJUGfIMXGfEm3STb6LzYeZWVH7nBG18H9MJJq1P3WHI3jhWsSOj4hv1PjJsQ2te9Jz6YcExK8UqTPIMx94X5bU7UI2CHSqPXf3oJ8rz7nHpnUGY701Cnw1SXLWi8YVzhGK7bzba9oUwBu6cUnaLL7DThgqhfn5XC9uIfrKaJ_iq7KKpV_sqw4UbUZ6x6tas9Un-fxjNZCM4nw-w");
    Headers headers = BaseApiTripTest.headers;

    @ParameterizedTest(name = "Test avec un client {0}")
    @CsvSource({"authenticate", "unauthenticate"})
    void should_return_200_401_error(String statusAuth){

        if (statusAuth.equals("authenticate")) {
            List<Header> headerList = new ArrayList<>(headers.asList());
            headerList.add(tokenHeader);
            BaseApiTripTest.requestSpecification()
                    .headers(new Headers(headerList))
                    .when()
                    .get("/trips/2")
                    .then()
                    .statusCode(200);
        }
        else {
            BaseApiTripTest.requestSpecification()
                    .headers(headers)
                    .when()
                    .get("/trips/2")
                    .then()
                    .statusCode(401);
        }

    }

    @Test
    void should_return_404_error(){
        List<Header> headerList = new ArrayList<>(headers.asList());
        headerList.add(tokenHeader);
        BaseApiTripTest.requestSpecification()
                .headers(new Headers(headerList))
                .when()
                .get("/trips/1000")
                .then()
                .statusCode(404);
    }
}
