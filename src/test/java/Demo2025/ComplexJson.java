package Demo2025;

import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class ComplexJson {

    public static void main(String[] args) {

        JsonPath js = new JsonPath(Payload.courses());
        int courseSize = js.getInt("courses.size()");
        System.out.println(courseSize);
        int purchaseAmt=Integer.parseInt(js.getString("dashboard.purchaseAmount"));
        System.out.println(purchaseAmt);
        System.out.println(js.getString("courses[0].title"));

        for(int i=0;i<courseSize;i++)
        {
            System.out.println("========================Title and Price====================");
            System.out.println(js.getString("courses["+i+"].title"));
            System.out.println(js.getString("courses["+i+"].price"));
        }
        System.out.println("========================================================");

        System.out.println(js.getString("courses[2].copies"));

        int seleniumPrice = Integer.parseInt(js.getString("courses[0].price"));
        int seleniumCopies= Integer.parseInt(js.getString("courses[0].copies"));
        int cypressPrice = Integer.parseInt(js.getString("courses[1].price"));
        int cypressCopies= Integer.parseInt(js.getString("courses[1].copies"));
        int rpaPrice = Integer.parseInt(js.getString("courses[2].price"));
        int rpaCopies= Integer.parseInt(js.getString("courses[2].copies"));

        int courseSum = (seleniumPrice*seleniumCopies)+(cypressPrice*cypressCopies)+(rpaPrice*rpaCopies);

        Assert.assertEquals(purchaseAmt,courseSum);

    }
}
