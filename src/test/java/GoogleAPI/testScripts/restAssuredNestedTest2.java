package GoogleAPI.testScripts;

import io.restassured.path.json.JsonPath;
import restAssuredFiles.Payload_Places;

public class restAssuredNestedTest2 {
	public static void main (String [] args)
	{
     
	JsonPath js = new JsonPath(Payload_Places.NestedJson());
	int size = js.getInt("courses.size()");
	System.out.println(size);
	
	
//	System.out.println(json);
    
	for (int i=0;i<size;i++) {
		     String json =js.getString("courses["+i+"].title");
	         if(json.equals("RPA")) 
	         
	         {
	        	 String copy =js.getString("courses["+i+"].copies");
	        	 System.out.println(copy);
	        	 break;
	         }
		
	}
	
    }
}
