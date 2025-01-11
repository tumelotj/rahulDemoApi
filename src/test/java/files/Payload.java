package files;

public class Payload {

    public static String addPlace()
    {
        return "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n";
    }



    public static String courses()
    {
        return "{\n" +
                "\n" +
                "\"dashboard\": {\n" +
                "\n" +
                "\"purchaseAmount\": 910,\n" +
                "\n" +
                "\"website\": \"rahulshettyacademy.com\"\n" +
                "\n" +
                "},\n" +
                "\n" +
                "\"courses\": [\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Selenium Python\",\n" +
                "\n" +
                "\"price\": 50,\n" +
                "\n" +
                "\"copies\": 6\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"Cypress\",\n" +
                "\n" +
                "\"price\": 40,\n" +
                "\n" +
                "\"copies\": 4\n" +
                "\n" +
                "},\n" +
                "\n" +
                "{\n" +
                "\n" +
                "\"title\": \"RPA\",\n" +
                "\n" +
                "\"price\": 45,\n" +
                "\n" +
                "\"copies\": 10\n" +
                "\n" +
                "}\n" +
                "\n" +
                "]\n" +
                "\n" +
                "}";
    }

    public static String addBook(String isbn, String isle)
    {
        return "{\n" +
                "\n" +
                "\"name\":\"Learn Appium Automation with Java\",\n" +
                "\"isbn\":\"bcd\",\n" +
                "\"aisle\":\"227\",\n" +
                "\"author\":\"John foe\"\n" +
                "}\n";
    }

    public static String addToCart(String id)
    {
        return "{\n" +
                "  \"_id\": \""+id+"\",\n" +
                "  \"product\": {\n" +
                "    \"_id\": \"6581ca979fd99c85e8ee7faf\",\n" +
                "    \"productName\": \"ADIDAS ORIGINAL\",\n" +
                "    \"productCategory\": \"household\",\n" +
                "    \"productSubCategory\": \"shoes\",\n" +
                "    \"productPrice\": 31500,\n" +
                "    \"productDescription\": \"Adidas shoes for Men\",\n" +
                "    \"productImage\": \"https://rahulshettyacademy.com/api/ecom/uploads/productImage_1650649488046.jpg\",\n" +
                "    \"productRating\": \"0\",\n" +
                "    \"productTotalOrders\": \"0\",\n" +
                "    \"productStatus\": true,\n" +
                "    \"productFor\": \"men\",\n" +
                "    \"productAddedBy\": \"admin@gmail.com\",\n" +
                "    \"__v\": 0\n" +
                "  }\n" +
                "}";
    }

    public static String createOrder(String prodID)
    {
        return "{\n" +
                "  \"orders\": [\n" +
                "    {\n" +
                "      \"country\": \"India\",\n" +
                "      \"productOrderedId\": \""+prodID+"\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
