package RestTests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C03_Correlation {
    @Test
    public void getTimeZone(){
        baseURI = "https://timeapi.io";
        Response response = given().queryParam("timeZone","Africa/Cairo")
                .log().all().when().get("/api/timezone/zone").then().statusCode(200)
                .body("timeZone",equalTo("Africa/Cairo")).extract().response();

        String s1 = response.jsonPath().getString("timeZone");
        String s2 = response.jsonPath().getString("currentLocalTime");
        String s3 = s2.substring(0,19).replace('T' ,' ');

        given()
                .contentType("application/json")
                .body(TestData.getTimeZoneDataCorrelation(s1,s3))
                .when().post("/api/conversion/converttimezone")
                .then().statusCode(200)
                .body("fromTimezone",equalTo("Africa/Cairo"));
    }
}
