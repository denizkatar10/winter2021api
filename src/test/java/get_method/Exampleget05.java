package get_method;

import static org.junit.Assert.*;
import base_urls.HerokuappBaseUrl;
import base_urls.JsonPlaceHolderBaseUrl;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exampleget05 extends JsonPlaceHolderBaseUrl {


    /*
    When
    I send GET Request to https://restful-booker.herokuapp.com/booking/1
    Then
    Response body should be like that;
    {
			    “firstname”: “Eric”,
			    “lastname”: “Smith”,
			    “totalprice”: 555,
			    “depositpaid”: false,
			    “bookingdates”: {
			        “checkin”: “2016-09-09”,
			        “checkout”: “2017-09-21”
    }
    }
    */

    @Test
    public void get01() {
        //1)Set the url
        spec.pathParam("first", "todos");

        //2)Set the expected data
        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("statusCode", 200);
        expectedDataMap.put("completed", false);
        expectedDataMap.put("userId", 1);
        expectedDataMap.put("title", "quis ut nam facilis et officia qui");
        expectedDataMap.put("Via", "1.1 vegur");
        expectedDataMap.put("Server", "cloudflare");

        //3)Send the request
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        JsonPath json = response.jsonPath();

        List<String> titleList = json.getList("title");
        System.out.println(titleList.contains("delectus"));


        //GSON: De-serialization ==> Json Data ----> Java Object
//        Map<String, Object> actualDataMap = response.as(HashMap.class);
//        System.out.println("Java Object from Json: " + actualDataMap);

        //GSON: Serialization ==> Java Object ---> Json Data
//        Gson gson = new Gson();
//        String jsonFromJavaObject = gson.toJson(actualDataMap);
//        System.out.println("Json from Java Object : " + jsonFromJavaObject);

    }

}
