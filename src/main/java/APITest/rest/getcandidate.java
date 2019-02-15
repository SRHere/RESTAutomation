package APITest.rest;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// The following code will verify check the get candidate response code

public class getcandidate {
	
	@Test
	public void getcandidatedetails()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://104.211.215.154:8082";
 		RequestSpecification httpRequest = RestAssured.given();
 		Response response = httpRequest.request(Method.GET, "/getAllCandidates/");
 		
 		int statucode=response.getStatusCode();
 		 		
 		System.out.println("the response code is "+statucode);
 		
 		Assert.assertEquals(statucode,200,"correct status obtained");
 
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
 
	}

}
 