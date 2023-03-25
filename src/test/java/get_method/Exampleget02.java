package get_method;
import static io.restassured.RestAssured.*;
import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Exampleget02 extends JsonPlaceHolderBaseUrl {

    @Test
    public void get02(){
        spec.pathParams("first","todos","second",2);

        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("completed",false);
        expectedDataMap.put("statusCode", 200);
        expectedDataMap.put("completed", false);
        expectedDataMap.put("userId", 1);
        expectedDataMap.put("title", "quis ut nam facilis et officia qui");
        expectedDataMap.put("Via", "1.1 vegur");
        expectedDataMap.put("Server", "cloudflare");

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        assertEquals(expectedDataMap.get("statusCode"), response.getStatusCode());
        assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));
        assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));


    }

}
