package OAuth2;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import io.restassured.path.json.JsonPath;

public class Oauth2_getRahulLibraby {

	public static void main(String[] args) {
		
		//STEP-1:- getting the Authorization Code from the 3rd party Authorization server
		String url = "https://rahulshettyacademy.com/getCourse.php?state=get_Authorization_Code&code=4%2F0AX4XfWiDLxqisSufQu-gKaplcVAWs_98gSB7gRH7e7hEaHGu5ASBJ35zPyQGWyE8BLfeSg&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent"; 
        String partialCode =  url.split("code=")[1];
        String code = partialCode.split("&scope")[0];
        System.out.println(code);
        
        //STEP-2:- hitting the resource server with a valid authorization code to get the Access Token
        String response = given().queryParam("Code",code)
               .queryParam("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
               .queryParam("client_secret","erZOWM9g3UtwNRj340YYaK_W")
               .queryParam("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
               .queryParam("grant_type","Authorization code")
               .when().post("https://www.googleapis.com/oauth2/v4/token")
               .then().extract().response().asString();
        
        System.out.println(response);
        JsonPath js= new JsonPath(response);        
        String AccessToken = js.getString("error");
        System.out.println("Your Aaccess Token is  = "+AccessToken);
        
        
        //STEP-3:- accessing the client server/application/website with the Valid Access Token
        String Librarby = given().queryParam("access_token",AccessToken)
        .when().get("https://rahulshettyacademy.com/getCourse.php")
        .then().extract().response().asString();
        
        System.out.println(Librarby);
        
        
	}

}
