package Demo2025;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import files.ReusableMethods;
import files.*;
public class DynamicJson {


    @Test(dataProvider="BooksData")

    public void addBook(String isbn,String aisle) throws IOException {

        RestAssured.baseURI="http://216.10.245.166";

        /**Line below is to convert content of Json file to Bytes, then from bytes to String. This helps
         * if you run the script that pulls data from external json file instead of java file */
        String convertToString = new String(Files.readAllBytes(Paths.get("C:\\Users\\tumel\\IdeaProjects\\Project2\\DemoProject\\src\\test\\java\\files\\rahulCourses.json")));

        String resp=given().header("Content-Type","application/json").
                body(Payload.addBook(isbn,aisle)).
                when().post("/Library/Addbook.php").
                then().assertThat().statusCode(200).extract().response().asString();

        JsonPath js= ReusableMethods.rawToJson(resp);
        String id=js.get("ID");
        System.out.println(id);
        //deleteBOok
    }


    @DataProvider(name="BooksData")
    public Object[][]  getData()

    {
        //array=collection of elements
        //multidimensional array= collection of arrays
        return new Object[][] {{"ojfwy","93693"},{"cweteeo","42503"}, {"okimfet","5733"} };
    }












}

