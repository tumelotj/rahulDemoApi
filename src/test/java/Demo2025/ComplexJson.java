package Demo2025;

import files.Payload;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComplexJson {

    @Test

    public void test() {

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

        int count = 0;
        for(int i=0;i<courseSize;i++)
        {
            int intPrice = js.getInt("courses["+i+"].price");
            int intCopies= js.getInt("courses["+i+"].copies");
            int product=intPrice*intCopies;
            count = count +product;
        }
        /*int seleniumPrice = js.getInt("courses[0].price");
        int seleniumCopies= js.getInt("courses[0].copies");
        int cypressPrice = js.getInt("courses[1].price");
        int cypressCopies= js.getInt("courses[1].copies");
        int rpaPrice = js.getInt("courses[2].price");
        int rpaCopies= js.getInt("courses[2].copies");
        int courseSum = (seleniumPrice*seleniumCopies)+(cypressPrice*cypressCopies)+(rpaPrice*rpaCopies);
*/
        Assert.assertEquals(purchaseAmt,count);

    }
}
