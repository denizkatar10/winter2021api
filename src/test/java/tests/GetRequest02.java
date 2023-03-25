package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;



public class GetRequest02 {
    /*
        When I send a GET request to REST API URL
        "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367"
        And Content-type is “application/JSON”
        Then
        HTTP Status Code should be 200
        And Response format should be "application/JSON"
           for the course whose id is "608bb976c9e4a800151ab367"
        And "code" should be "WP100"
        And "image" should be "wordpress.jpg"
        And English "title" should be "Wordpress"
        And Turkish "shortDescription"  should be "Wordpress in nasıl kullanılacağını öğreneceğiz"
   */
    @Test
    public void get01(){
        //1.Set the url
        String url = "https://api-techproed-test.herokuapp.com/courses/608bb976c9e4a800151ab367";
        //2.Set the expected data (we will learn it later)

        //3.Send the request (like click on Send button in Postman)
        Response response = given().
                accept("application/json").
                    when().
                get(url);
        response.prettyPrint();

        //4.Assertion

    }

}
