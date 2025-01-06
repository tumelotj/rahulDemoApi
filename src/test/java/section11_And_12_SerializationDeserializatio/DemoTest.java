package section11_And_12_SerializationDeserializatio;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class DemoTest {

    @Test
            public void test()
    {
        Course sp = new Course();
        Payload p = new Payload();

      //String linkedin= sp.getLinkeIn();
        //sp.setSurname("Tsotetsi");

       String test= given().body(p.getJson())
                .when().get("https://rahulshettyacademy.com/getCourse.php").asString();


       System.out.println(test);
    }



}
