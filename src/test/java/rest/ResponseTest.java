package rest;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ResponseTest extends WithRestAssured {

    @Test
    void verify_single_header() {
        Response response = get("/people");
        System.out.println( response.headers());

        assertThat(response.header("Access-Control-Allow-Credentials"), is("true"));
    }

    @Test
    void verify_multiple_headers() {
       get("/people")
               .then().log().headers()
               .assertThat().headers("X-Powered-By", "Express", "Vary","Origin, Accept-Encoding");
    }
}
