package serialization;

import org.testng.annotations.Test;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.Arrays;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class TestExample {
    @Test
    public void testCaseReqres(){
        ContactClass contactClass = new ContactClass();
        contactClass.setEmail("mohamed@example.com");
        contactClass.setPhone("123456789");

        Addressclass addressclass = new Addressclass();
        addressclass.setCity("cairo");
        addressclass.setCountry("Egypt");


        exampleC exampleC = new exampleC();

        exampleC.setName("Mohamed");
        exampleC.setJob("Software Test Engineer");
        exampleC.setSkills(Arrays.asList(
                "Java",
                "Selenium",
                "Rest Assured"
        ));
        exampleC.setAddress(addressclass);
        exampleC.setContact(contactClass);


        given().baseUri("https://reqres.in/")
                .contentType("application/json")
                .body(exampleC).log().all()
                .when()
                .post("api/users").then().log().all()
                .statusCode(201);

    }
}
