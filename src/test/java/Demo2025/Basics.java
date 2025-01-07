package Demo2025;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import files.*;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class Basics {
    public static void main(String[] args) {

        RestAssured.baseURI="https://rahulshettyacademy.com";
        //RestAssured works with Given, When, Then operations
        //Given - used when collecting data
        //When - Sends the request (http method and resource)
        //Then - Validate the response (AssertThat method)

      String response=given().log().all().queryParam("key","qaclick123").queryParam("Content-Type","json").body(Payload.addPlace())
                .when().post("/maps/api/place/add/json").
                then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
                .header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();

        //Add place-> Update place with new address -> Get Place to validate if new address is present in response
        JsonPath js = new JsonPath(response);
        String placeId = js.getString("place_id");
        System.out.println("Place ID: "+placeId);

        String newAddress = "The Bronx Apartments, RSA";
        String expectedAdd = "The Bronx Apartments, RSA";
        //Update Place - PUT method
        given().log().all().queryParam("key","qaclick123").queryParam("Content-Type","json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200).header("server","Apache/2.4.52 (Ubuntu)");

        //Get Updated Place - GET method
        given().queryParam("key","qaclick123").queryParam("place_id",placeId)
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200).body("address",equalTo(expectedAdd))
                .header("server","Apache/2.4.52 (Ubuntu)");
        Assert.assertEquals(newAddress,expectedAdd);


    }
}
