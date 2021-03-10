/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package api.actions;

import static io.restassured.RestAssured.given;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specifications.Builders;

/**
 * @author nites
 *
 */
public class APIActions {
	public RequestSpecification reqSpec;
	public ResponseSpecification resSpec;
	public Response response;

	public Response getEarthCloseApproachSortData() throws IOException {
		response = given().spec(Builders.requestSpecification().queryParam("dist-max", "10LD")
				.queryParam("date-min", "2018-01-01").queryParam("sort", "dist")).when().get();		
		return response;
	

	}
//
	public Response getAllCloseApproachAsteroidData() throws IOException {
		response = given().spec(Builders.requestSpecification().queryParam("des", "433")
				.queryParam("date-min", "1900-01-01").queryParam("date-max", "2100-01-01")).queryParam("dist-max", "0.2").when().get();
		return response;
	

	}

}
