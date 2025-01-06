package apiTestingDemo;
import apiFiles.Payload;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class CoursesDemo {


    @Test

    public void test()
    {

        RestAssured.baseURI="";

        JsonPath js = new JsonPath(Payload.getCourses());
        String strTitle = js.getString("courses.title");
        System.out.println(strTitle);
        String[] arrCourses = strTitle.split(",");
        int numCourses = arrCourses.length;
        System.out.println("Number of courses returned by API is : "+numCourses);

        String purchaseAmt = js.getString("courses.price");
        System.out.println("Purchase amount : "+purchaseAmt);

        String firstCourseTitle = js.getString("courses[0].title");
        System.out.println("First Course : "+firstCourseTitle);


    }


}
