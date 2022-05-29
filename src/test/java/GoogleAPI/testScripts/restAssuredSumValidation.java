package GoogleAPI.testScripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import restAssuredFiles.Payload_Places;

public class restAssuredSumValidation {
	@Test
	public void sumValidation()
	{
     
	JsonPath js = new JsonPath(Payload_Places.NestedJson());
	int size = js.getInt("courses.size()");
	System.out.println(size);
	
	
//	System.out.println(json);

    int calculated_price =0;
	
	for (int i=0;i<size;i++) {
		     int price =js.getInt("courses["+i+"].price");
		     int copy =js.getInt("courses["+i+"].copies");
	      
//	         System.out.println(price1*copy1);
	         calculated_price = calculated_price+(price*copy);	         
	         }
	
	
	     System.out.println("calculated price  = "+calculated_price);
		
	     int total_amount = js.get("dashboard.purchaseAmount");
	     System.out.println("total amount      = "+total_amount);
	     
	     if (total_amount==calculated_price) {
	     System.out.println("calculation is okay");}
	     else{System.out.println("calculation is mismatched");}
	     
	     Assert.assertEquals(calculated_price, total_amount);
//	     Assert.assertNotEquals(calculated_price, total_amount);
	}
	
    }
