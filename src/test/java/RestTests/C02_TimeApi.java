package RestTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C02_TimeApi {
    @Test
    public void convertTimeZone(){
        baseURI = "https://timeapi.io";
        given().header("Content-Type","application/json")
                .body("{\n" +
                        "  \"fromTimeZone\": \"Africa/Cairo\",\n" +
                        "  \"dateTime\": \"2026-07-31 19:25:00\",\n" +
                        "  \"toTimeZone\": \"America/Los_Angeles\",\n" +
                        "  \"dstAmbiguity\": \"\"\n" +
                        "}").log().all()
                .when().post("/api/conversion/converttimezone")
                .then().log().all().statusCode(200)
                .body("fromTimezone",equalTo("Africa/Cairo"))
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .time(lessThan(5000L));

    }
    @Test
    public void convertTimeZone2(){
        baseURI = "https://timeapi.io";
        given().header("Content-Type","application/json")
                .body(TestData.getTimeZoneData()).log().all()
                .when().post("/api/conversion/converttimezone")
                .then().log().all().statusCode(200)
                .body("fromTimezone",equalTo("Africa/Cairo"))
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .time(lessThan(5000L));

    }
}
