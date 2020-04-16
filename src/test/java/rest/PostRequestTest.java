package rest;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequestTest extends WithRestAssured {

    @Test
    void post_adds_a_new_person_to_people_data() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"name\":\"Edirin\"}")
                .post("/people")
                .then().statusCode(201);
    }

    /**
     * You need to add Jackson databind
     * as a dependency so its available
     * in the classpath
     */

    @Test
    void post_with_map_as_body() {
        Map<String, String> nameMap = new HashMap<>();
        nameMap.put("name", "SDET");

        given()
                .contentType(ContentType.JSON)
                .body(nameMap)
                .post("/people")
                .then().statusCode(201);
    }

    /**
     * You need to add Jackson databind
     * as a dependency so its available
     * in the classpath
     */
    @Test
    void post_with_pojo_as_body() {
        Person person = new Person("I am a class");

        given()
                .contentType(ContentType.JSON)
                .body(person)
                .post("/people")
                .then().statusCode(201);
    }
}
