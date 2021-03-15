/**
 * @author Nitesh Wayafalkar
 * @Project Title   SBDB - API Automation
 * 
 */
package api.actions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import commons.QueryParameters;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import specifications.Builders;


public class APIActions {

	/**
	 * Initialize Logger
	 * 
	 */
	static final Properties Log4j = new Properties();
	public static Logger LOGGER = Logger.getLogger(APIActions.class);


	Builders builders = new Builders();
	public RequestSpecification reqSpec;
	public ResponseSpecification resSpec;
	public Response response;
	public QueryParameters param;

	/**
	 * @param sort
	 * @return Response body
	 * @throws IOException
	 * 
	 *                     This method is build request and sort data in ascending
	 *                     and descending order based sort variable
	 */
	public Response getEarthCloseApproachSort(String sort) throws IOException {
		/**
		 * Set values to Query parameter to build request
		 */
		param = new QueryParameters();
		param.setSort(sort);
		param.setDateMin("2021-01-01");
		param.setDateMax("2021-02-01");
		param.setDistMax("5LD");

		/**
		 * Build GET request using RequestSpecification's static
		 * method @requestSpecification
		 */
		response = given().spec(builders.requestSpecification().queryParam("dist-max", param.getDistMax())
				.queryParam("date-min", param.getDateMin()).queryParam("date-max", param.getDateMax())
				.queryParam("sort", param.getSort())).when().get();
		LOGGER.debug(response.getBody());
		return response;

	}

	/**
	 * @return Response body
	 * @throws IOException
	 */
	public Response getAllCloseApproachAsteroidData() throws IOException {
		/**
		 * Set values to Query parameter to build request
		 */
		param = new QueryParameters();
		param.setDes("433");
		param.setDateMax("2100-01-01");
		param.setDateMin("1900-01-01");
		param.setDistMax("0.2");

		/**
		 * Build GET request using RequestSpecification's static
		 * method @requestSpecification
		 */

		response = given().spec(builders.requestSpecification().queryParam("des", param.getDes())
				.queryParam("date-min", param.getDateMin()).queryParam("date-max", param.getDateMax())
				.queryParam("dist-max", param.getDistMax())).when().get();
		LOGGER.debug(response.getBody());
		return response;

	}

	/**
	 * @param des
	 * @param orbit_id
	 * @return Response body
	 * @throws IOException
	 */
	public Response getAllCloseApproachAsteroidOrbitIDForDesignation(String des, String orbit_id) throws IOException {
		/**
		 * Set values to Query parameter to build request
		 */
		param = new QueryParameters();
		param.setDes(des);
		param.setDateMax("2100-01-01");
		param.setDateMin("1900-01-01");
		param.setDistMax("0.2");

		/**
		 * Build GET request using RequestSpecification's static
		 * method @requestSpecification
		 */
		response = given().spec(builders.requestSpecification().queryParam("des", param.getDes())
				.queryParam("date-min", param.getDateMin()).queryParam("date-max", param.getDateMax())
				.queryParam("dist-max", param.getDistMax())).when().get();
		LOGGER.debug(response.getBody());
		return response;

	}

}
