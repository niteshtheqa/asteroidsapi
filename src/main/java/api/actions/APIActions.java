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

	public Response getEarthCloseApproachSortData() throws IOException {
		param = new QueryParameters();
		param.setSort("-dist");
		param.setDate_min("1900-01-01");
		param.setDist_max("10LD");

		response = given().spec(builders.requestSpecification().queryParam("dist-max", param.getDist_max())
				.queryParam("date-min", param.getDate_min()).queryParam("sort", param.getSort())).when().get();

		return response;

	}

	public Response getAllCloseApproachAsteroidData() throws IOException {
		param = new QueryParameters();
		param.setDes("433");
		param.setDate_max("2100-01-01");
		param.setDate_min("1900-01-01");
		param.setDist_max("0.2");

		response = given().spec(builders.requestSpecification().queryParam("des", param.getDes())
				.queryParam("date-min", param.getDate_min()).queryParam("date-max", param.getDate_max())
				.queryParam("dist-max", param.getDist_max())).when().get();

		return response;

	}

	public Response getAllCloseApproachAsteroidOrbitIDForDesignation(String des, String orbit_id) throws IOException {

		param = new QueryParameters();
		param.setDes(des);
		param.setDate_max("2100-01-01");
		param.setDate_min("1900-01-01");
		param.setDist_max("0.2");

		response = given().spec(builders.requestSpecification().queryParam("des", param.getDes())
				.queryParam("date-min", param.getDate_min()).queryParam("date-max", param.getDate_max())
				.queryParam("dist-max", param.getDist_max())).when().get();
		return response;

	}

}
