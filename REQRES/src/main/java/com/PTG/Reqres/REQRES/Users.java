package com.PTG.Reqres.REQRES;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Users {
	RequestSpecification httpRequest;

	public Users() {
		String baseURI = "https://reqres.in";
		RestAssured.baseURI = baseURI;
		httpRequest = RestAssured.given();

	}

	public void GetUsersDetails() {
		Response response = httpRequest.request(Method.GET, "/api/users?page=2");

		// System.out.println("Response=>" + response.prettyPrint());

	}

	public void getSingleUser(int userid) {

		Response response = httpRequest.request(Method.GET, "/api/users/" + userid);
		int status = response.getStatusCode();
		System.out.println("Response Status Code: " + status);

		// System.out.println("Status received => " + response.getStatusLine());
		System.out.println("Response=>" + response.prettyPrint());
		Assert.assertEquals(status, 200);

	}

	public void getSingleUserNotfound(int userid) {

		Response response = httpRequest.request(Method.GET, "/api/users/" + userid);

		int status = response.getStatusCode();

		System.out.println("Response Status Code: " + status);

		// System.out.println("Status received => " + response.getStatusLine());
		System.out.println("Response=>" + response.prettyPrint());

		Assert.assertEquals(status, 404);

	}

	public void getListResource() {
		Response response = httpRequest.request(Method.GET, "/api/unknown/");
		int status = response.getStatusCode();
		System.out.println("Response Status Code: " + status);
		System.out.println("Response=>" + response.prettyPrint());
		Assert.assertEquals(status, 200);

	}
	
	
	public void postUser() {
		JSONObject requestParams = new JSONObject(); 
		requestParams.put("name", "raju"); 
		requestParams.put("job", "manager"); 
		// Add a header stating the Request body is a JSON 
		// Add a header stating the Request body is a JSON 
		httpRequest.header("Content-Type", "application/json"); // Add the Json to the body of the request 
		httpRequest.body(requestParams.toJSONString()); 
		Response response = httpRequest.post("/api/users/"); 
		
		int status = response.getStatusCode();
		System.out.println("Response Status Code: " + status);
		System.out.println("Response=>" + response.prettyPrint());
		Assert.assertEquals(status, 201);
		
		JsonPath jPath = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String name = jPath.get("name");

		// Let us print the city variable to see what we got
		System.out.println("name received from Response " + name);

		// Validate the response
		Assert.assertEquals(name, "raju");
	}
	
	public void putUser() {
		JSONObject requestParams = new JSONObject(); 
		requestParams.put("name", "siva"); 
		requestParams.put("job", "member"); 
		// Add a header stating the Request body is a JSON 
		// Add a header stating the Request body is a JSON 
		httpRequest.header("Content-Type", "application/json"); // Add the Json to the body of the request 
		httpRequest.body(requestParams.toJSONString()); 
		Response response = httpRequest.put("/api/users/2"); 
		
		int status = response.getStatusCode();
		System.out.println("Response Status Code: " + status);
		System.out.println("Response=>" + response.prettyPrint());
		Assert.assertEquals(status, 200);
		
		JsonPath jPath = response.jsonPath();

		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		String name = jPath.get("name");

		// Let us print the city variable to see what we got
		System.out.println("name received from Response " + name);

		// Validate the response
		Assert.assertEquals(name, "siva");
		
		
		
	}
		public void deleteUser() {
			JSONObject requestParams = new JSONObject(); 
			requestParams.put("name", "siva"); 
			requestParams.put("job", "member"); 
			// Add a header stating the Request body is a JSON 
			// Add a header stating the Request body is a JSON 
			httpRequest.header("Content-Type", "application/json"); // Add the Json to the body of the request 
			httpRequest.body(requestParams.toJSONString()); 
			Response response = httpRequest.delete("/api/users/2"); 
			
			int status = response.getStatusCode();
			System.out.println("Response Status Code: " + status);
			System.out.println("Response=>" + response.prettyPrint());
			Assert.assertEquals(status, 204);
			
		}
	}


