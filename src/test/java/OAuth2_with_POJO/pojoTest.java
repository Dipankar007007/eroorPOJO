package OAuth2_with_POJO;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.parsing.Parser;

public class pojoTest{
	
	public static void main (String [] args) {
		
	Get_Json  myclass =	given().log().all().queryParam("key"," qaclick123").body("{\r\n"
			+ "  \"instructor\": \"RahulShetty\",\r\n"
			+ "  \"url\":\"rahulshettyacademy.com\",\r\n"
			+ "  \"services\":\"projectSupport\",\r\n"
			+ "  \"expertise\": \"Aitomation\",\r\n"
			+ "  \"courses\": {\r\n"
			+ "           \"WebAutomation\":[\r\n"
			+ "             {\r\n"
			+ "             \"courseTitle\":\"Selenium Webdriver Java\",\r\n"
			+ "             \"price\":\"50\" \r\n"
			+ "             },\r\n"
			+ "             {\r\n"
			+ "             \"courseTitle\":\"Cypress\",\r\n"
			+ "             \"price\":\"40\" \r\n"
			+ "             },\r\n"
			+ "             {\r\n"
			+ "             \"courseTitle\":\"Protractor\",\r\n"
			+ "             \"price\":\"40\" \r\n"
			+ "             }\r\n"
			+ "            ],\r\n"
			+ "         \"api\":[\r\n"
			+ "             {\r\n"
			+ "             \"courseTitle\":\"Rest Assured Automation using Java\",\r\n"
			+ "             \"price\":\"50\"\r\n"
			+ "             },\r\n"
			+ "             {\r\n"
			+ "             \"courseTitle\":\"SoapUI Webservices testing\",\r\n"
			+ "             \"price\":\"50\" \r\n"
			+ "             }\r\n"
			+ "           ],\r\n"
			+ "         \"mobile\": [\r\n"
			+ "             {  \r\n"
			+ "             \"courseTitle\":\"Appium-Mobile Automation using Java\",\r\n"
			+ "             \"price\":\"50\" \r\n"
			+ "             }\r\n"
			+ "            ]\r\n"
			+ "        },\r\n"
			+ "     \"LinkedIn\":\"https://www.linkedin.com/in/rahul-shetty-trainer/\"\r\n"
			+ "}").expect().defaultParser(Parser.JSON)
		        .when().post("https://rahulshettyacademy.com/maps/api/place/add/json?key= qaclick123")
		        .as(Get_Json.class);

	          myclass.setLinkedIn("htttp.sdfsdfsdf.dfsdfsdf.d");
			   
	          String s = myclass.getLinkedIn();
	          System.out.println(s);	          
	          
	}
	
}


