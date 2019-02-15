package APITest.rest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vladsch.flexmark.ast.Content;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

// The following code will verify if the API is returning the body with a particular content C00113 

public class validatebody {
	
	@Test
	public void checkbodycontent()
	{   
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://104.211.215.154:8082";
 		RequestSpecification httpRequest = RestAssured.given();
 		Response response = httpRequest.request(Method.GET, "/getAllInternsUnAssigned/");
 		  		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is =>  " + responseBody);
		
		Assert.assertEquals(responseBody.contains("C00113"), true,"response body should contain C00113");
		
 
	}

}
 