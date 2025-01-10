package Demo2025;
import io.restassured.RestAssured;import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.io.File;
public class BugTest {
    public static void main(String[] args) {

        /**
         * Check how to handle path parameter and how to attach a file in your request.
         * Path Param is different from Query Param
         * **/


        RestAssured.baseURI="https://rahulshettyacademy-team.atlassian.net/";
        String createIssueResponse 	= given()
                .header("Content-Type","application/json")
                .header("Authorization","Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB")
                .body("{\n" +
                        "    \"fields\": {\n" +
                        "       \"project\":\n" +
                        "       {\n" +
                        "          \"key\": \"TEST\"\n" +
                        "       },\n" +
                        "       \"summary\": \"REST ye merry gentlemen.\",\n" +
                        "       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\n" +
                        "       \"issuetype\": {\n" +
                        "          \"name\": \"Bug\"\n" +
                        "       }\n" +
                        "   }\n" +
                        "}\n")
                .log().all()
                .post("rest/api/3/issue").then().log().all().assertThat().statusCode(201).contentType("application/json")
                .extract().response().asString();
        JsonPath js = new JsonPath(createIssueResponse);
        String issueId = js.getString("id");
        System.out.println(issueId);
        given()
                .pathParam("key", issueId)
                .header("X-Atlassian-Token","no-check")
                .header("Authorization","Basic bWVudG9yQHJhaHVsc2hldHR5YWNhZGVteS5jb206QVRBVFQzeEZmR0YwdFNlOHYzNUtILWQtU3U4NUFMckIyTjdDNXIwY0pJU0djdFIwRFBybUhfZjVlUmg4dE5UUVV6UVp1dTFkMXJHdkRjUzNHRnV4TVE4WklSNU9tdFlPbUszLUxBbVU4OEFTM3JrOGkwODFSYV9kQTlPQ3J5QjRERXlFWldJYXpwWGw3VDFTWnBLY0ZOSDBucjVBMUtLQ3FuWVBldzFLR2JSMWowa2JFdGVNVFZFPUZCMzhFM0JB")
                .multiPart("file",new File("/Users/rahulshetty/Downloads/IMG_0926.jpeg")).log().all()
                .post("rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
        //Add attachment		 		 		 		 		 							}
    }}