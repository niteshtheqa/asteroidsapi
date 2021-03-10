/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import api.actions.APIActions;
import io.restassured.response.Response;
import utils.Utils;

/**
 * @author nitesh wayafalkar
 *
 */
public class TestCloseApproach {

	public APIActions apiActions = new APIActions();
	public Response response;

	@BeforeSuite()
	public void setUp() throws IOException {
		Utils.loadProperties();

	}

	@Test(enabled = true, description = "get Earth close-approach data for NEOs within 10 lunar distances on or after 2018-Jan-01 sorted by distance")
	public void TestEarthCloseApproachData() throws IOException {
		response = apiActions.getEarthCloseApproachSortData();
		System.out.println(response.getBody().prettyPrint());
	}

	@Test(description = "get all close-approach data for asteroid 433 Eros within 0.2 au between 1900-Jan-01 and 2100-Jan-01")
	public void TestAllCloseApproachAsteroidData() throws IOException {
		response = apiActions.getAllCloseApproachAsteroidData();

		assertTrue(Integer.parseInt(Utils.getJsonPath(response, "count")) > 0);

		System.out.println(response.getBody().prettyPrint());
	}

}
