package get_method;

import base_urls.HerokuappBaseUrl;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.*;

public class GetRequest05 extends HerokuappBaseUrl {

    /*
    When
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking
	  	 Then
	  		Among the data there should be someone whose first name is “Mark” and last name is “Ericsson”

     */

    @Test
    public void get01(){

        //1)Set the URL
        spec.pathParam("first", "booking").
                queryParams("firstname","Deniz");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        assertTrue(response.asString().contains("bookingid"));

    }




}
