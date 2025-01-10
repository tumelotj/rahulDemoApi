package Demo2025;

import io.restassured.RestAssured;
import org.testng.annotations.Test;
import pojo.AddPlace;
import pojo.GetCourse;
import pojo.Location;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Serialization {

    @Test
    public void test()
    {

        RestAssured.baseURI="https://rahulshettyacademy.com";

        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setName("Frontline house");
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setAddress("29, side layout, cohen 09");
        addPlace.setWebsite("http://google.com");
        addPlace.setLanguage("French-IN");
        List<String> myList = new ArrayList<String>();
        myList.add("shoe park");
        myList.add("shop");
        addPlace.setTypes(myList);
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlace.setLocation(location);

        given().log().all().queryParam("key","qaclick123").queryParam("Content-Type","application/json")
                .body(addPlace)
                .when().post("/maps/api/place/add/json")
                .then().log().all().assertThat().statusCode(200).extract().response();

    }
}
