package apiTestingDemo;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import section11_And_12_SerializationDeserializatio.Course;


public class Section10_OAuth2 {

    @Test
    public void test()
    {

        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AdQt8qjCgd3TzLnZr97-pSpZT1tZw3a2XQI1pnlzZ4yGwQqxZXYiR02YyU56m4GsigrsyQ&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";


        String[] partialCode=url.split("code=");
        String originCode[]=partialCode[1].split("&scope");
        String strCode = originCode[0];

       String accessTokenResponse= given().urlEncodingEnabled(false).queryParams("code",strCode)
                .queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
                .queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
                .queryParams("grant_type","authorization_code")
                .when()
                .log().all().post("https://www.googleapis.com/oauth2/v4/token").asString();

       System.out.println(accessTokenResponse);


       JsonPath js = new JsonPath(accessTokenResponse);
       String accessToken = js.getString("access_token");

      String resp= given().queryParam("access_token",accessToken)
               .when().log().all().get("https://rahulshettyacademy.com/getCourse.php").asString();


       System.out.println(resp);


        Course c = given().queryParam("access_token",accessToken).expect().defaultParser(Parser.JSON)
                .when().get("https://rahulshettyacademy.com/getCourse.php").as(Course.class);

        System.out.println(c.getInstructor());

        System.out.println(c.getCourses().getWebAutomation().get(1).getPrice());

        for (int i= 0; i<c.getCourses().getWebAutomation().size();i++)
        {
            System.out.println(c.getCourses().getWebAutomation().get(i).getCourseTitle());
        }

    }
}
