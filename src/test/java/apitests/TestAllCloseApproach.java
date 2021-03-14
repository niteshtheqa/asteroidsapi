/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package apitests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basetest.BaseTest;
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
public class TestAllCloseApproach extends BaseTest {

	

	@Test(enabled = true, description = "get all close-approach data for asteroid 433 Eros within 0.2 au between 1900-Jan-01 and 2100-Jan-01")
	public void TestAllCloseApproachAsteroidBetweenDateRange() throws IOException, ParseException {
		String dateMin = "1900-Jan-01";
		String dateMax = "2100-Jan-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");

		// Checking response is having at least one record
		ResponsePojo data = apiActions.getAllCloseApproachAsteroidData().getBody().as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());

		List<Fields> fields = Utils.extractAndSetFields(data);
		for (int i = 0; i < fields.size(); i++) {
			Date convertedDate = sdf.parse(fields.get(i).getCd());
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

		ResponsePojo data = apiActions.getAllCloseApproachAsteroidData().getBody().as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());
		BigDecimal dist = new BigDecimal(0.2);
		dist = dist.setScale(16, BigDecimal.ROUND_HALF_UP);
		List<Fields> fields = Utils.extractAndSetFields(data);
		for (int i = 0; i < fields.size(); i++) {
			int result = fields.get(i).getDist().compareTo(dist);
			assertFalse(result == 1, "Asteroid is out 0.2 AU range");
		}

	}

	@Test(description = "Verify all close-approach data is not NULL/Empty")
	public void TestAllCloseApproachAsteroidResponseIsNotNull() throws IOException {
		ResponsePojo data = apiActions.getAllCloseApproachAsteroidData().getBody().as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());

	}

	@Test(dataProviderClass = DataProviderImpl.class, dataProvider = "DesignationProvider", description = "Verify Orbit ID with different inputs of Designation")
	public void TestOrbitIDWithRespectiveDesignationValue(String des, String value) throws IOException {
		ResponsePojo data = apiActions.getAllCloseApproachAsteroidOrbitIDForDesignation(des, value.trim()).getBody()
				.as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());

		List<Fields> fields = Utils.extractAndSetFields(data);
		for (int i = 0; i < fields.size(); i++) {
			CommonFunctions.assertOrbitIDs(fields, i, value);
		}

	}

}
