package serialization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class TestSerialize {
    @Test
    public void testa(){
        baseURI = "https://timeapi.io";
        TimeZoneC dataObj = new TimeZoneC();

        dataObj.setFromTimeZone("Africa/Cairo");
        dataObj.setDateTime("2026-07-31 19:25:00");
        dataObj.setToTimeZone("America/Los_Angeles");
        dataObj.setDstAmbiguity("");

        given().header("Content-Type","application/json")
                .body(dataObj).log().all()
                .when().post("/api/conversion/converttimezone")
                .then().log().all().statusCode(200)
                .body("fromTimezone",equalTo("Africa/Cairo"))
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .time(lessThan(5000L));
    }

}
