package rest;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class PutRequest extends WithRestAssured {

    @Test
    void update_name() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"Awesome\"}")
                .put("/people/3")
                .then()
                .statusCode(200);
    }
}
