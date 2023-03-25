package get_method;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;

public class Exampleget01 {

    protected RequestSpecification spec;
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("https://jsonplaceholder.typicode.com").build();
    }

    @Test
    public void get01(){

        spec.pathParam("first", "todos");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        List<Integer> idList = jsonPath.getList("findAll{it.id>190}.id");
        System.out.println(idList);

        assertEquals(10, idList.size());

        List<Integer> userIdList = jsonPath.getList("findAll{it.userId<5}.userId");
        System.out.println(userIdList);

        Collections.sort(userIdList);
        assertEquals((Integer) 4, userIdList.get(userIdList.size()-1));

        List<String> titleList = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println(titleList);

    }



}
