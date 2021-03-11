/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package tests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import api.actions.APIActions;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Utils;

/**
 * @author nitesh wayafalkar
 *
 */
public class TestCloseApproach {

	public APIActions apiActions;
	public Response response;

	@BeforeMethod()
	public void setUp() throws IOException {
		apiActions = new APIActions();
		Reporter.log("Test execution started...");
		Utils.loadProperties();

	}

	@Test(enabled = true, description = "get Earth close-approach data for NEOs within 10 lunar distances on or after 2018-Jan-01 sorted by distance")
	public void TestEarthCloseApproachData() throws IOException {

		response = apiActions.getEarthCloseApproachSortData();

	}

	@Test(enabled = true, description = "get all close-approach data for asteroid 433 Eros within 0.2 au between 1900-Jan-01 and 2100-Jan-01")
	public void TestAllCloseApproachAsteroidData() throws IOException {
		response = apiActions.getAllCloseApproachAsteroidData();

		assertTrue(Integer.parseInt(Utils.getJsonElement(response, "count")) > 0);

	}

	@Test(description = "get all close-approach data for asteroid 433 Eros within 0.2 au between 1900-Jan-01 and 2100-Jan-01")
	public void TestAllCloseApproachAsteroidResponseIsNotNull() throws IOException {
		response = apiActions.getAllCloseApproachAsteroidData();
		assertTrue(Integer.parseInt(Utils.getJsonElement(response, "count")) > 0);

		//assertTrue(Double.parseDouble(Utils.getJsonElementFromNestedJson(response, "signature").get("version")) == 1.2);
		
		System.out.println(response.jsonPath().getString("data[0][1]"));
	}

	@AfterMethod()
	public void tearDown() {
		Reporter.log("Test execution completed...");
	}

}
