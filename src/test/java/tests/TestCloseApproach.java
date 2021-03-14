/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commons.CommonFunctions;
import commons.DataProviderImpl;
import pojo.Fields;
import pojo.ResponsePojo;
import reporter.ExtentReportListner;
import utils.Utils;

/**
 * @author nitesh wayafalkar
 *
 */
@Listeners(ExtentReportListner.class)
public class TestCloseApproach extends BaseTest {

	@Test(enabled = true, description = "get Earth close-approach data for NEOs within 10 lunar distances on or after 2018-Jan-01 sorted by distance")
	public void TestEarthCloseApproachData() throws IOException {

		// De-serialization of Response
		ResponsePojo data = apiActions.getEarthCloseApproachSortData().getBody().as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());
		System.out.println(data.getSignature().getSource());

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
		assertTrue("Version is invalid",
				Utils.getJsonElementFromNestedJson(response, "signature").get("version").equals("1.2"));

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

		double dist = 0.2000000000000000;
		BigDecimal bdLon = new BigDecimal(dist);
		bdLon = bdLon.setScale(16, BigDecimal.ROUND_HALF_UP);
		// Hitting to Endpoint
		response = apiActions.getAllCloseApproachAsteroidData();
		// Checking response is having at least one record
		assertTrue("Count is zero", Integer.parseInt(Utils.getJsonElement(response, "count")) > 0);
		assertTrue("Version is invalid",
				Utils.getJsonElementFromNestedJson(response, "signature").get("version").equals("1.2"));

		List<?> data = Utils.getElementFromJsonArray(response, "data");
		for (int i = 0; i < data.size(); i++) {
			String distances = String.valueOf(data.get(i)).split(",")[4];
			System.out.println("Disntace : " + distances);
			assertFalse("Asteroid is out 0.2 AU range",
					Math.floor(Double.parseDouble(distances)) > bdLon.doubleValue());
		}

	}

	@Test(description = "Verify all close-approach data is not NULL/Empty")
	public void TestAllCloseApproachAsteroidResponseIsNotNull() throws IOException {
		response = apiActions.getAllCloseApproachAsteroidData();

		assertTrue("Count is zero", Integer.parseInt(Utils.getJsonElement(response, "count")) > 0);
		assertTrue("Version is invalid",
				Utils.getJsonElementFromNestedJson(response, "signature").get("version").equals("1.2"));
	}

	@Test(dataProviderClass = DataProviderImpl.class, dataProvider = "DesignationProvider", description = "Verify Orbit ID with different inputs of Designation")
	public void TestOrbitIDWithRespectiveDesignationValue(String des, String value) throws IOException {
		ResponsePojo data = apiActions.getAllCloseApproachAsteroidOrbitIDForDesignation(des, value.trim()).getBody()
				.as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());
		CommonFunctions.extractAndSetFields(data);

		List<Fields> fields = data.getFileds();
		for (int i = 0; i < fields.size(); i++) {
			System.out.println(fields.get(i).getOrbitId().trim());
		}
		
//		if (Integer.parseInt(Utils.getJsonElement(response, "count")) > -1) {
//			List<?> data = Utils.getElementFromJsonArray(response, "data");
//			String Ordbit_ID = String.valueOf(data.get(1)).split(",")[1].trim();
//			assertTrue("Expected Ordbit Id is not received", value.equals(Ordbit_ID));
//		} else {
//			System.out.println("No Orbit_ID present for Des :" + value);
//		}
//
	}

}
