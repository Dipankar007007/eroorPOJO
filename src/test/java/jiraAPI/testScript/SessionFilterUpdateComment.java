package jiraAPI.testScript;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
//import static org.hamcrest.Matchers.*;

import java.io.File;


public class SessionFilterUpdateComment {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://localhost:8080";
		
		SessionFilter session = new SessionFilter();
		
		//POST - login (creating session)
		String response1 =given().header("Content-Type","application/json").body("{ \"username\": \"iampb1\", \"password\": \"941153239588pp\" }").filter(session)
		.when().post("/rest/auth/1/session")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 =new JsonPath(response1);
		String result1 = js1.getString("session.value");
		System.out.println("session id is  = "+result1);
		
		
		//PUT - (updating the comment)
		String response2= given().pathParam("issueID","10004").pathParam("commentID","10000").header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \"make love not war\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}").filter(session)
		 .when().put("/rest/api/2/issue/{issueID}/comment/{commentID}")
		 .then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js2 =new JsonPath(response2);
		String result2 = js2.getString("body");
		System.out.println("edited comment is = "+result2);
		
		// POST - (attaching the file)
		String response3 =given().header("X-Atlassian-Token","no-check").pathParam("issueID", "10004").filter(session).multiPart("file",new File("C:\\Users\\prash\\eclipse-workspace\\RestAssured\\src\\test\\java\\kaandi"))
		.when().post("/rest/api/2/issue/{issueID}/attachments")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		
		JsonPath js3 =new JsonPath(response3);
		String result3 = js3.getString("filename");
		System.out.println("attached file name is  = "+result3);
		
        // GET - (get issue detail)
		
	String response4 =given().filter(session).pathParam("issueID", "10004").queryParam("fields", "summary").
	when().get("/rest/api/2/issue/{issueID}")
	.then().assertThat().statusCode(200).extract().response().asString();
	
	
	System.out.println(response4);
//	JsonPath js4 =new JsonPath(response4);
//	String result4 = js4.getString("filename");
//	System.out.println("attached file name is  = "+result4);
	
	}

}
