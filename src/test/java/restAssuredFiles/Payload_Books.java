package restAssuredFiles;

public class Payload_Books {
	
	public static String addBook(String isbn,String aisle ) {
		String body = "{\r\n"
				+ "\r\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
				+ "\"isbn\":\""+isbn+"\",\r\n"
				+ "\"aisle\":\""+aisle+"\",\r\n"
				+ "\"author\":\"John foe\"\r\n"
				+ "}\r\n"
				+ "";
		return body;
	}
	
	public static String deleteBook(String Book_ID ) {
		String body = "{\r\n"
				+ " \r\n"
				+ "\"ID\" : \""+Book_ID+"\"\r\n"
				+ " \r\n"
				+ "} \r\n"
				+ "";
		return body;
	}
	
	

}
