package RestTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C01_HeroKuapp {
    @Test
    public void getUserData(){
        given().log().all()
                .when()
                .get("https://reqres.in/api/users/2")
                .then().log().all().statusCode(200).
                body("data.id",equalTo(2)).
                body("data.email",equalTo("janet.weaver@reqres.in"));
    }
    @Test
    public void getUserData2(){
        baseURI = "https://reqres.in";
        given()
                .when()
                .get("/api/users/2")
                .then().statusCode(200).
                body("data.id",equalTo(2)).
                body("data.email",equalTo("janet.weaver@reqres.in"));
    }
    @Test
    public void getUserData3(){
        given().baseUri("https://reqres.in")
                .when()
                .get("/api/users/2")
                .then().statusCode(200).
                body("data.id",equalTo(2)).
                body("data.email",equalTo("janet.weaver@reqres.in"));
    }
}
