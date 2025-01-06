package apiTestingDemo;
import apiFiles.Payload;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import io.restassured.RestAssured;

public class DemoTesting {
    public static void main(String[] args)
    {

        RestAssured.baseURI="https://rahulshettyacademy.com";

        /********************Add Address *********************************/
       String response= given().queryParam("key","qaclick123").body(Payload.addPlace()).
                when().post("/maps/api/place/add/json").
                then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP")).extract().response().asString();

        System.out.println("=============================");
       System.out.println(response);
        System.out.println("=============================");

        JsonPath js = new JsonPath(response);
       String placeID = js.get("place_id");


        /******************** Get Address *********************************/

        given().queryParam("key","qaclick123").queryParam("place_id",placeID)
                .when().get("/maps/api/place/get/json")
                .then().log().all().assertThat().statusCode(200);


        /******************** Update Address *********************************/


        String expectedAdd = "70 winter walk, USA";

       String resp = given().queryParam("key","qaclick123").queryParam("place_id",placeID).body("{\n" +
                "\"place_id\":\""+placeID+"\",\n" +
                "\"address\":\"70 winter walk, USA\",\n" +
                "\"key\":\"qaclick123\"\n" +
                "}\n")
                .when().put("/maps/api/place/update/json")
                .then().log().all().assertThat().statusCode(200).body("msg",equalTo("Address successfully updated")).extract().response().asString();

        /******************** get Updated Address *********************************/

       String jsp2 = given().queryParam("key","qaclick123").queryParam("place_id",placeID)
       .when().get("/maps/api/place/get/json")
               .then().log().all().statusCode(200).extract().response().asString();

        System.out.println("=============================");
        System.out.println(jsp2);
        System.out.println("=============================");

        JsonPath jsonPath = new JsonPath(jsp2);
       String actualAdd = jsonPath.get("address");
       Assert.assertEquals(actualAdd,expectedAdd);


    }
}
