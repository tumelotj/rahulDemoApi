package section11_And_12_SerializationDeserializatio;

public class Payload {


    public String getJson()
    {
        return " { \"instructor\": \"RahulShetty\", \"url\": \"rahulshettycademy.com\", \"services\": \"projectSupport\", \"expertise\": \"Automation\", \"courses\": { \"webAutomation\": [ { \"courseTitle\": \"Selenium Webdriver Java\", \"price\": \"50\" }, { \"courseTitle\": \"Cypress\",\n" +
                "                \"price\": \"40\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"courseTitle\": \"Protractor\",\n" +
                "                \"price\": \"40\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"api\": [\n" +
                "            {\n" +
                "                \"courseTitle\": \"Rest Assured Automation using Java\",\n" +
                "                \"price\": \"50\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"courseTitle\": \"SoapUI Webservices testing\",\n" +
                "                \"price\": \"40\"\n" +
                "            }\n" +
                "        ],\n" +
                "        \"mobile\": [\n" +
                "            {\n" +
                "                \"courseTitle\": \"Appium-Mobile Automation using Java\",\n" +
                "                \"price\": \"50\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"linkedIn\": \"https://www.linkedin.com/in/rahul-shetty-trainer/\"\n" +
                "}\n";
    }
}
