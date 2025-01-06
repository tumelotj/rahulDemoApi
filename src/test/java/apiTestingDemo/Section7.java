package apiTestingDemo;
import apiFiles.Payload;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Section7 {

    @Test//(dataProvider = "addingBook")

    public void test() throws IOException {
        RestAssured.baseURI="http://216.10.245.166";

       String response1= given().body(new String(Files.readAllBytes(Paths.get("C://Users//tumel//OneDrive//Desktop//Rest API Training//Section 7//testThis.json")))). //body(Payload.addBook(isb,aisl)).
                when().post("Library/Addbook.php").
                then().log().all().assertThat().statusCode(200).extract().response().asString();

       JsonPath js1 = new JsonPath(response1);
       String id  = js1.get("ID");
       System.out.println("ID is : "+id);
       System.out.println(response1);
    }


    @DataProvider(name="addingBook")

    public Object[][] dataProvider()
    {
        return new Object[][] {{"Tumelo","Book1"},{"Thabang","Book2"}};
    }
}
