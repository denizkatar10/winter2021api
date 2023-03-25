package post_method;
import base_urls.HerokuappBaseUrl;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import org.junit.Test;
import test_data.HerOkuAppTestData;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class PostRequest02 extends JsonPlaceHolderBaseUrl {
    /*
       When
	  		I send POST Request to the Url https://jsonplaceholder.typicode.com/todos
	  		with the request body {
								    "userId": 55,
								    "title": "Tidy your room",
								    "completed": false
								   }
		Then
			Status code is 201
			And response body is like {
									    "userId": 55,
									    "title": "Tidy your room",
									    "completed": false,
									    "id": 201
									  }
     */

    @Test
    public void  post01(){
        //1)Set the url
        spec.pathParam("first", "todos");

        //2) Set expected data
        JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();

        //3) Send POST Request
        Response response = given().spec(spec).
                auth().basic("admin", "1234").
                contentType(ContentType.JSON).
                body(expectedData.expectedDataSetUp()).
                when().post("/{first}");
        response.prettyPrint();
    }

    //4)Assert output
    //1.Way: By using GSON
    //Map<String, Object> actualData = response.as(HashMap.class);

}
