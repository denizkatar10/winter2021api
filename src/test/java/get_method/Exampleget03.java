package get_method;
import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;
public class Exampleget03 extends HerokuappBaseUrl {

    @Test
    public void get01(){

        spec.pathParams("first","booking","second",1);

        Response response = given().spec(spec).when().get("/{first}/{second}");

        Map<String,String> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2016-03-14");
        bookingdates.put("checkout", "2021-06-22");

        Map<String, Object> expectedDataMap = new HashMap<>();
        expectedDataMap.put("firstname", "Mary");
        expectedDataMap.put("lastname", "Jones");
        expectedDataMap.put("totalprice", 963);
        expectedDataMap.put("depositpaid", true);
        expectedDataMap.put("bookingdates", bookingdates);

        System.out.println(expectedDataMap);

        System.out.println("===================================================================");

        response.prettyPrint();

        System.out.println("===================================================================");

        Map<String,Object> actualDataMap = response.as(HashMap.class);

        System.out.println(actualDataMap);

        assertEquals(expectedDataMap.get("firstname"), actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"), actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"), actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"), actualDataMap.get("depositpaid"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkin"), ((Map)actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(((Map)expectedDataMap.get("bookingdates")).get("checkout"), ((Map)actualDataMap.get("bookingdates")).get("checkout"));



    }



}
