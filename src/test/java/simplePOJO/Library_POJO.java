package simplePOJO;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class Library_POJO {

	public static void main(String[] args) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
//		String response =given().header("Content-Type","application/json").body("{\r\n"
//				+ "\r\n"
//				+ "\"name\":\"Learn Appium Automation with Java-By Prashant Sir\",\r\n"
//				+ "\"isbn\":\"BookID-\",\r\n"
//				+ "\"aisle\":\"23\",\r\n"
//				+ "\"author\":\"John foe\"\r\n"
//				+ "}\r\n"
//				+ " \r\n"
//				+ "")
//		.when().post("Library/Addbook.php")
//		.then().assertThat().statusCode(200).extract().asString();
//		
//		JsonPath js = new JsonPath(response);
//		String bookID = js.getString("ID");
//		System.out.println(bookID);
		
		
//		pojopojoGET st = given().queryParam("ID","BookID-285665").expect().defaultParser(Parser.JSON).log().all()
//		.when().get("/Library/GetBook.php")
//		.then().extract().as(pojopojoGET.class);
//		System.out.println(st);
//		
//		System.out.println(st.getBook_name());
		
		pojopojoGET pj = new pojopojoGET();
		pj.setBook_name("hapur me tahalka -Seraj ki fati gaand");
		pj.setAisle("abcd");
		pj.setIsbn("1234");
		pj.setAuthor("pahadi Amigo");
		
		 String response =given().header("Content-Type","application/json").body(pj).log().all()
        .when().post("Library/Addbook.php")
        .then().assertThat().statusCode(200).extract().asString();
		
		System.out.println(response);
		
	}

}
