
Feature: Testing sample API's

	@tc1
	Scenario: Validate google navigation api
	Given I want to validate navigation API with header or parameter
	When I want to perform GET call to "http://api.openweathermap.org/data/2.5/weather?q=London&APPID=8bfb777a7ae285b5f79ff7f0ece496a2"
	Then I want to verify responce code as "200"	      
	
	@tc2
	Scenario: Valiadte post man api to create data
	Given I want to validate create data api with headers
	And I want to create JSON object for request body
	When I want to perform POST call to "https://postman-echo.com/post"
	Then I want to verify response code as "200"
	
	@tc3
	Scenario: Valiadte post man api to create data
	Given I want to validate create data api with headers
	And I want to input request body payload as a JSON file "C:\\Users\\dsaishankar\\Desktop\\test.json"
	When I want to perform POST call to "https://postman-echo.com/post"
	Then I want to verify response code as "200"
	
