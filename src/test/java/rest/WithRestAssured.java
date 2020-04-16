package rest;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class WithRestAssured {

    @BeforeClass
    void setUp() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "http://localhost:3000";
    }
}
