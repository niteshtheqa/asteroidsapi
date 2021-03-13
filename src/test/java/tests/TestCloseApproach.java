/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package tests;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import api.actions.APIActions;
import io.restassured.response.Response;
import reporter.ExtentReportListner;
import utils.Utils;

/**
 * @author nitesh wayafalkar
 *
 */
@Listeners(ExtentReportListner.class)
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
	public void TestAllCloseApproachAsteroidBetweenDateRange() throws IOException, ParseException {
		String dateMin = "1900-Jan-01";
		String dateMax = "2100-Jan-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
		// Hitting to Endpoint
		response = apiActions.getAllCloseApproachAsteroidData();
		// Checking response is having at least one record
		assertTrue("Count is zero", Integer.parseInt(Utils.getJsonElement(response, "count")) > 0);

		List<?> data = Utils.getElementFromJsonArray(response, "data");
		for (int i = 0; i < data.size(); i++) {
			Date convertedDate = sdf.parse(String.valueOf(data.get(i)).split(",")[3]);
			String date1 = sdf.format(convertedDate);
			int yearOfCloseApproach = Integer.parseInt(date1.substring(0, 4));
			boolean monthOfCloseApproach = date1.substring(5, 8) == "Jan";
			assertTrue("time of close-approach is less than Min Date",
					yearOfCloseApproach > Integer.parseInt(dateMin.substring(0, 4)));
			assertTrue("time of close-approach is greater than Max Date",
					yearOfCloseApproach < Integer.parseInt(dateMax.substring(0, 4)) || !monthOfCloseApproach);

		}

	}

	@Test(enabled = true, description = "get all close-approach data for asteroid 433 Eros within 0.2 au")
	public void TestAllCloseApproachAsteroidWithinDistanceRange() throws IOException, ParseException {
		String dateMin = "1900-Jan-01";
		String dateMax = "2100-Jan-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
		// Hitting to Endpoint
		response = apiActions.getAllCloseApproachAsteroidData();
		// Checking response is having at least one record
		assertTrue("Count is zero", Integer.parseInt(Utils.getJsonElement(response, "count")) > 0);

	}

	@Test(description = "get all close-approach data is not NULL/Empty")
	public void TestAllCloseApproachAsteroidResponseIsNotNull() throws IOException {
		response = apiActions.getAllCloseApproachAsteroidData();

		assertTrue("", Integer.parseInt(Utils.getJsonElement(response, "count")) > 0);

		assertTrue("",
				Double.parseDouble(Utils.getJsonElementFromNestedJson(response, "signature").get("version")) == 1.2);
	}

	@AfterMethod()
	public void tearDown() {
		Reporter.log("Test execution completed...");
	}

}
