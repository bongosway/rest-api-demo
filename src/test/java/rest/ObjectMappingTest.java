package rest;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ObjectMappingTest extends WithRestAssured {

    @Test
    void get_person_from_request() {
        PersonDto personDto = get("/people/1").as(PersonDto.class);
        assertThat(personDto.getName(), equalToIgnoringCase("Edirin"));
    }

    @Test
    void get_person_array() {
        ArrayList<Map<Integer, PersonDto>> personList = get("/people").then().extract().response().jsonPath().get();
        personList.get(0).get("name");
    }
}