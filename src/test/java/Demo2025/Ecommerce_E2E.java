package Demo2025;

import ecommercePojo.LoginRequestPayload;
import ecommercePojo.LoginResposePayload;
import files.Payload;
import files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Ecommerce_E2E {

    @Test

    public  void test()
    {

        LoginRequestPayload login = new LoginRequestPayload();
        login.setUserEmail("hazardtumelo@gmail.com");
        login.setUserPassword("General");

        /***** Request and Response Spec Builder ****/
        RequestSpecification loginReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/api/ecom/auth/login")
                .setContentType(ContentType.JSON)
                .addHeader("server","Apache/2.4.52 (Ubuntu)").build();
        RequestSpecification loginRequest = given().log().all().spec(loginReq);
        ResponseSpecification response = new ResponseSpecBuilder().expectStatusCode(200).build();

        /**Login to app using Serialization methods - Set methods
         * built response payload to class deserialization - get methods **/
        LoginResposePayload loginResponse = loginRequest.body(login)
                .when().post()
                .then().log().all().spec(response).extract().as(LoginResposePayload.class);

        RequestSpecification requestPostLogin = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/api/ecom")
                .setContentType(ContentType.JSON).addHeader("server","Apache/2.4.52 (Ubuntu)")
                .addHeader("authorization",loginResponse.getToken()).build();
        RequestSpecification req = given().log().all().spec(requestPostLogin);

        /**Add to Cart**/
        req.body(Payload.addToCart(loginResponse.getUserId())).
                when().post("/user/add-to-cart")
                .then().log().all().spec(response).extract();

        JsonPath js = new JsonPath(Payload.addToCart(loginResponse.getUserId()));
        String productID = js.getString("product._id");
       Response resOrder= req.body(Payload.createOrder(productID))
                .when().post("/order/create-order")
                .then().log().all().statusCode(201).extract().response();

       String strResOrder= resOrder.asString();
        JsonPath js1 = new JsonPath(Payload.addToCart(strResOrder));


        String orderID=js1.getString("orders(0)");


        req.queryParam("id",orderID)
                .get("/order/get-orders-details")
                .then().spec(response).extract();
    }
}
