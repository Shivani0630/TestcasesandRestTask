package Petstore;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.When;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CrudOperationinpet {
	//Task-3
	@Test
	public void crudoperation()
	{
		baseURI="https://petstore.swagger.io/v2";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", 10);
		map.put ("username","shivamma" );
		map.put ( "firstName", "shivu");
		 map.put("lastName", "A");
		 map.put("email", "shivuishu0630@gmail.com");
		 map.put("password", "shivu0630");
		 map.put("phone", "9980815920");
		 map.put("userStatus", 12);	 
		 
		   Response res = given().body(map).contentType(ContentType.JSON)
		 .when().post("/user");
		int UserName = res.jsonPath().get("code");
		when().get("/user/shivamma").
		 then().assertThat().statusCode(UserName)
		 .contentType(ContentType.JSON)
		 .log()
		 .all();
	}
	//Task-1and2
	@Test
	public void Post()
	{
		baseURI="https://petstore.swagger.io/v2";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", 10);
		map.put ("username","shivamma" );
		map.put ( "firstName", "shivu");
		 map.put("lastName", "A");
		 map.put("email", "shivuishu0630@gmail.com");
		 map.put("password", "shivu0630");
		 map.put("phone", "9980815920");
		 map.put("userStatus", 12);	 
		 
	       given().body(map).contentType(ContentType.JSON)
		 .when().post("/user").then().assertThat().statusCode(200).log().all();
	}
	@Test
	public void get()
	{
		baseURI="https://petstore.swagger.io/v2";
		when().get("/user/shivamma").then().assertThat().log().all();
	}
	@Test
	public void Put()
	{
		baseURI="https://petstore.swagger.io/v2";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", 10);
		map.put ("username","shivani" );
		map.put ( "firstName", "shivu");
		 map.put("lastName", "A");
		 map.put("email", "shivuishu0630@gmail.com");
		 map.put("password", "shivu0630");
		 map.put("phone", "9980815920");
		 map.put("userStatus", 12);	 
		 
	       given().body(map).contentType(ContentType.JSON)
		 .when().put("/user/shivamma").then().assertThat().statusCode(200).log().all();
	}
@Test
public void delete()
{
	baseURI="https://petstore.swagger.io/v2";
	when().delete("/user/shivani").then().assertThat().log().all();
}
}
