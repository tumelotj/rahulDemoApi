package Demo2025;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Basics {
    public static void main(String[] args) {

        RestAssured.baseURI="https://rahulshettyacademy.com";
        //RestAssured works with Given, When, Then operations
        //Given - used when collecting data
        //When - Sends the request (http method and resource)
        //Then - Validate the response (AssertThat method)

        given().log().all().queryParam("key","qaclick123").queryParam("Content-Type","json")
                .body("{\n" +
                        "  \"location\": {\n" +
                        "    \"lat\": -38.383494,\n" +
                        "    \"lng\": 33.427362\n" +
                        "  },\n" +
                        "  \"accuracy\": 50,\n" +
                        "  \"name\": \"Frontline house\",\n" +
                        "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                        "  \"address\": \"29, side layout, cohen 09\",\n" +
                        "  \"types\": [\n" +
                        "    \"shoe park\",\n" +
                        "    \"shop\"\n" +
                        "  ],\n" +
                        "  \"website\": \"http://google.com\",\n" +
                        "  \"language\": \"French-IN\"\n" +
                        "}\n").when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
                .body("scope",equalTo("APP")).header("server","Apache/2.4.52 (Ubuntu)");

        //Add place-> Update place with new address -> Get Place to validate if new address is present in response



    }
}
