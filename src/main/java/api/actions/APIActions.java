/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package api.actions;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import commons.QueryParameters;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specifications.Builders;

/**
 * @author nites
 *
 */
public class APIActions {

	Builders builders = new Builders();
	public RequestSpecification reqSpec;
	public ResponseSpecification resSpec;
	public Response response;
	public QueryParameters param;

	public Response getEarthCloseApproachSortDesc() throws IOException {
		param = new QueryParameters();
		param.setSort("-dist");
		param.setDateMin("2020-01-01");
		param.setDistMax("10LD");

		response = given().spec(builders.requestSpecification().queryParam("dist-max", param.getDistMax())
				.queryParam("date-min", param.getDateMin()).queryParam("sort", param.getSort())).when().get();

		return response;

	}

	
	public Response getEarthCloseApproachSortAsc() throws IOException {
		param = new QueryParameters();
		param.setSort("dist");
		param.setDateMin("2021-01-01");
		param.setDateMax("2021-02-01");
		param.setDistMax("5LD");

		response = given().spec(builders.requestSpecification().queryParam("dist-max", param.getDistMax())
				.queryParam("date-min", param.getDateMin()).queryParam("date-max", param.getDateMax()).queryParam("sort", param.getSort())).when().get();

		return response;

	}
	
	
	public Response getAllCloseApproachAsteroidData() throws IOException {
		param = new QueryParameters();
		param.setDes("433");
		param.setDateMax("2100-01-01");
		param.setDateMin("1900-01-01");
		param.setDistMax("0.2");

		response = given().spec(builders.requestSpecification().queryParam("des", param.getDes())
				.queryParam("date-min", param.getDateMin()).queryParam("date-max", param.getDateMax())
				.queryParam("dist-max", param.getDistMax())).when().get();

		return response;

	}

	public Response getAllCloseApproachAsteroidOrbitIDForDesignation(String des, String orbit_id) throws IOException {

		param = new QueryParameters();
		param.setDes(des);
		param.setDateMax("2100-01-01");
		param.setDateMin("1900-01-01");
		param.setDistMax("0.2");

		response = given().spec(builders.requestSpecification().queryParam("des", param.getDes())
				.queryParam("date-min", param.getDateMin()).queryParam("date-max", param.getDateMax())
				.queryParam("dist-max", param.getDistMax())).when().get();
		return response;

	}

}
