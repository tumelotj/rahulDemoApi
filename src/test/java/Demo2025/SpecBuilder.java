package Demo2025;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SpecBuilder {
    public static void main(String[] args) {

        RestAssured.baseURI="https://rahulshettyacademy.com";
        //RestAssured works with Given, When, Then operations
        //Given - used when collecting data
        //When - Sends the request (http method and resource)
        //Then - Validate the response (AssertThat method)

        /*** Request Spec Builder ***/
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key","qaclick123")
                .setContentType(ContentType.JSON).build();
        RequestSpecification rs = given().spec(req);

        /*** Response Spec Builder ***/
        ResponseSpecification resSpec= new ResponseSpecBuilder().expectStatusCode(200)
                .expectHeader("server","Apache/2.4.52 (Ubuntu)").build();

      Response response=rs.body(Payload.addPlace())
              .when().post("/maps/api/place/add/json")
              .then().log().all().spec(resSpec).extract().response();

      String respo = response.asString();

        //Add place-> Update place with new address -> Get Place to validate if new address is present in response
        JsonPath js = new JsonPath(respo);
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
