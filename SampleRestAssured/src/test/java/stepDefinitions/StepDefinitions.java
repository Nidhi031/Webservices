package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.net.URL;

import static io.restassured.matcher.RestAssuredMatchers.*;

import org.json.simple.JSONObject;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.JsonObject;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class StepDefinitions {
	
	Response res,resbody;
	RequestSpecification request;

@Given("^I want to validate navigation API with header or parameter$")
public void i_want_to_validate_navigation_API_with_header_or_parameter() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	given();
	
}

@When("^I want to perform GET call to \"([^\"]*)\"$")
public void i_want_to_perform_GET_call_to(String URI) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	res = when().get(URI);
	
	
}


@Then("^I want to verify responce code as \"([^\"]*)\"$")
public void i_want_to_verify_responce_code_as(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
    int statusCode = res.getStatusCode();
    System.out.println(statusCode);
    Assert.assertEquals(statusCode, 200);

}


@Given("^I want to validate create data api with headers$")
public void i_want_to_validate_create_data_api_with_headers() throws Throwable {
  // Write code here that turns the phrase above into concrete actions	
  request = RestAssured.given();
  request.header("Content-Type","application/json");
}


@When("^I want to create JSON object for request body$")
public void i_want_to_create_JSON_object_for_request_body() throws Throwable {
  // Write code here that turns the phrase above into concrete actions
  JSONObject json = new JSONObject();
  json.put("text", "hero");
  json.put("latitude", "40.7127837");
  json.put("longitude", "-74.00594130000002");
  json.put("distance", "10000");
  json.put("sortCriteria", "distanceAsc"); 
  request.body(json);
  
}

@When("^I want to perform POST call to \"([^\"]*)\"$")
public void i_want_to_perform_POST_call_to(String arg1) throws Throwable {
  // Write code here that turns the phrase above into concrete actions
	  res = request.post("https://postman-echo.com/post");
  
}


@Then("^I want to verify response code as \"([^\"]*)\"$")
public void i_want_to_verify_response_code_as(String arg1) throws Throwable {
  // Write code here that turns the phrase above into concrete actions
	System.out.println(res.getStatusCode());
//  res.then().assertThat().statusCode(200);
  res.then().assertThat().statusCode(200).and().body("data.text", equalTo("hero"));
}

@Given("^I want to input request body payload as a JSON file \"([^\"]*)\"$")
public void i_want_to_input_request_body_payload_as_a_JSON_file(String inputFile) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	
	File file = new File(inputFile);
	request.body(file).with().contentType("application/json");
	
    
}
	

}
