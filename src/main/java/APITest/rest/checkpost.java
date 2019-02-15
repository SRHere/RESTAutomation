package APITest.rest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// The following code verify the post method .

public class checkpost {
	
	@Test
	public void checkpostmethod()
	{		
		RestAssured.baseURI ="http://104.211.215.154:8082";
		RequestSpecification request = RestAssured.given();
	 
		JSONObject requestParams = new JSONObject();

		
		requestParams.put("seatId","KOC-025");
		requestParams.put("systemId","KOCv1");
		requestParams.put("location","vismaya");
		requestParams.put("empId","u51448");
		requestParams.put("startDate","2018-06-12");
		requestParams.put("endDate","2018-08-31");
		requestParams.put("returnMessage","Allocated");
			

		System.out.println("The json is "+request.body(requestParams.toJSONString()));
		
		
		
		request.body(requestParams.toJSONString());
		Response response = request.post("/addSeat/");
	 
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, "201");
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}

}
 