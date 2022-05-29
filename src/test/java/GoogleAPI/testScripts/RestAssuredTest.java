package GoogleAPI.testScripts;

import  static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import restAssuredFiles.Payload_Places;

public class RestAssuredTest {
             
	public static void main(String[] args) throws Exception 
	
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		String Resource_ADD = "/maps/api/place/add/json";
		String newAddress   = "221-B Baker Street";
		
		
		// POST (ADDING THE PLACE)
		String Response = given().queryParam("key","qaclick123").body(Payload_Places.addPlace())
		.when().post(Resource_ADD)
		.then()
		.extract().response().asString();
		
		System.out.println(Response);
		
	    JsonPath js = new JsonPath(Response);
	    String plcaeID= js.get("place_id");
	    System.out.println(plcaeID);
	    
	    
	   //PUT (UPDATING THE PLACE) 
	   String Resource_UPDATE= "maps/api/place/update/json";
	   String response2= given().queryParam("key", "qaclick").header("Content-Type","application/json").body("{\r\n"
	    		+ "\"place_id\":\""+plcaeID+"\",\r\n"
	    		+ "\"address\":\""+newAddress+"\",\r\n"
	    		+ "\"key\":\"qaclick123\"\r\n"
	    		+ "}\r\n"
	    		+ "")
        .when().put(Resource_UPDATE)
        .then().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"))
        .extract().response().asString();
	    System.out.println(response2);
	    
	    
	    //GET (VALIDATING THE UPDATED ADDRESS VALUE) 
	    String Response_GET =given().queryParam("key","qaclick123").queryParam("place_id",plcaeID)
	    .when().get("/maps/api/place/get/json")
	    .then().assertThat().statusCode(200).body("address",equalTo(newAddress))
	    .extract().response().asString();
	    
	    System.out.println(Response_GET);
	    
	    JsonPath jp = new JsonPath(Response_GET);
	    String UpdatedAddress =jp.getString("address");
	    System.out.println("Updated Address is  => "+ UpdatedAddress);
	    
	    
	}
	}