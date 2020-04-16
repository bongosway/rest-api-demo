package rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class GetRequestTest extends WithRestAssured {

    @Test
    void check_status_code_is_200() {
        get("/people")
                .then()
                .statusCode(200);
    }

    @Test
    void check_status_code_and_list_size() {
         get("/people")
                 .then()
                 .assertThat()
                 .statusCode(200)
                 .and()
                 .body("name", hasSize(2));
    }

    @Test
    void get_with_jsonpath() {
        //Shorthand for path
         String personName = get("/people").path("name[1]");
//                 .then()
//                 .assertThat()
//                 .statusCode(200)
//                 .and()
//                 .extract().response()
//                 .jsonPath().getString("name[1]");
        System.out.println( personName );
    }

    @Test
    void verify_list_item() {
        get("/lotto")
                .then()
                .body("lotto.winners.winnerId", hasItems(23, 54));
    }

    /**
     * Params can be Multi-value parameter
     */
    @Test
    void get_with_params() {
        given()
                .param("id", 1, 2)
                .when()
                .get("/people")
                .then()
                .body("name", hasItems("Edirin", "SDET"));

    }

    @Test
    void get_with_path_param() {
        given().
                pathParam("countryCode", "IND").
                pathParam("stateCode", "UP").
                when().
                get("http://services.groupkt.com/state/get/{countryCode}/{stateCode}").
                then().log().body()
                .statusCode(200)
                .and()
                .body("RestResponse.messages", hasItems("State found matching code [UP]."));
    }
}
