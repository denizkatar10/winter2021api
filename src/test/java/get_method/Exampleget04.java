package get_method;
import base_urls.OpenWeatherBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.ExampleTestData;
import test_data.OpenWeatherMapTestData;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;
public class Exampleget04 extends OpenWeatherBaseUrl {

    @Test
    public void get01(){

        //set the url
        spec.pathParams("first","data","second",2.5,"third","weather").
                queryParams("q","London","appid","f4ffe3b2ef1fcb3600ab1d7fbc88c2f0");

        //set expected data

        ExampleTestData expectedData = new ExampleTestData();

        //send the request

        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");

        response.prettyPrint();

        JsonPath json = response.jsonPath();

        //assert outputs

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.coordSetUp().get("lat"),(Float) json.getFloat("coord.lat"));

        assertEquals(expectedData.weatherSetUp().get("main"),json.getString("weather[0].main"));

        assertEquals(expectedData.expectedDataSetUp().get("base"),json.getString("base"));

        assertEquals(expectedData.mainSetUp().get("humidity"),(Float) json.getFloat("main.humidity"));

        assertEquals(expectedData.expectedDataSetUp().get("visibility"),json.getInt("visibility"));


    }
}
