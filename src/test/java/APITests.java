import static io.restassured.RestAssured.*; //static import
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITests {

    @Test

    void test1() {
        /*api test - go to google and search for a 'sample rest api for testing'
        https://reqres.in/
        Scroll down to 'Give it a Try' -> GET List Users
        Right click at the endpoint -> open in new -> copy the url that is the endpoint
        */

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println("Response: " + response.asString());
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());
        System.out.println(("Time taken: " + response.getTime()));
        System.out.println("Header: " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
         Assert.assertEquals(statusCode, 200);
       // Assert.assertEquals(statusCode, 201); //this will fail

        /*
        "Response" is the class from RestAssure
        "response" is the name of the variable where the value is stored

        other response options:
        response.getBody();
        response.getHeaders();
        */

    }
    @Test
    void test2() {
        given().
                get("https://reqres.in/api/users?page=2").
                then().
                statusCode(200);
    }
}
