package RestTests;

import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class C04_DataPro {
    @Test(dataProvider = "TimeZones")
    public void getTimeZone(String timeZone){
        baseURI = "https://timeapi.io";
        Response response = given().queryParam("timeZone",timeZone)
                .log().all().when().get("/api/timezone/zone").then().statusCode(200)
                .body("timeZone",equalTo(timeZone)).extract().response();
    }

    @Test
    public void convertTimeZon(){
        baseURI = "https://timeapi.io";

        File jsonFile = new File("src/main/resources/Data/timeZone.json");
        given().header("Content-Type","application/json")
                .body(jsonFile).log().all()
                .when().post("/api/conversion/converttimezone")
                .then().log().all().statusCode(200)
                .body("fromTimezone",equalTo("Africa/Cairo"))
                .header("Content-Type",equalTo("application/json; charset=utf-8"))
                .time(lessThan(5000L));
    }

    @DataProvider(name = "TimeZones")
    public Object[][] giveData(){
        return new Object[][]{
                {"Africa/Accra"},
                {"America/Argentina/Cordoba"},
                {"Africa/Cairo"}
        };
    }
}
