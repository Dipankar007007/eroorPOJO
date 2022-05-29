package OAuth2_with_POJO;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import restAssuredFiles.Payload_Places;

public class RestAssuredTest {
             
	public static void main(String[] args) throws Exception 
	
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Resource_ADD = "/maps/api/place/add/json";
		String newAddress   = "221-B Baker Street";
		
		
		// POST (ADDING THE PLACE)
		given().queryParam("key","qaclick123").expect().defaultParser(Parser.JSON).body("{\r\n"
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
				+ "}")
		.when().get("/maps/api/place/get/json").as(Courses.class);
	    
		
		
	    
	    
	    
	    
	}
	}