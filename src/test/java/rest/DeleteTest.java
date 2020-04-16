package rest;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.delete;

public class DeleteTest extends WithRestAssured {

    @Test
    void delete_name() {
        //Add Id of person to be deleted
        delete("/people/:id").then().statusCode(200);
    }
}
