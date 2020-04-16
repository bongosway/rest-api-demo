package rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ExceptionDisplayTest extends WithRestAssured {

    @Test
    void display_all_failure_scenario() {
        given().
                param("x", "y").
                expect().
                statusCode(400).
                body("lotto.lottoId", equalTo(6)).
                when().
                get("/lotto");
    }

    @Test
    void display_first_failure_scenario() {
        given().
                param("x", "y").
                when().
                get("/lotto").
                then().
                statusCode(400).
                body("lotto.lottoId", equalTo(6));
    }


}
