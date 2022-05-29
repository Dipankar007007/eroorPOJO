package jiraAPI.testScript;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
//import static org.hamcrest.Matchers.*;


public class AddAttachment {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://localhost:8080";
		
		SessionFilter session = new SessionFilter();
		
		
		String response1 =given().header("Content-Type","application/json").body("{ \"username\": \"iampb1\", \"password\": \"941153239588pp\" }").filter(session)
		.when().post("/rest/auth/1/session")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js1 =new JsonPath(response1);
		String result1 = js1.getString("session.value");
		System.out.println(result1);
		
		
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
		System.out.println(result2);

	}

}
