/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package apitests;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.testng.annotations.Test;

import basetest.BaseTest;
import commons.CommonFunctions;
import commons.QueryParameters;
import pojo.Fields;
import pojo.ResponsePojo;
import utils.Utils;

/**
 * @author Nitesh Wayafalkar
 *
 */
public class TestEarthCloseApproach extends BaseTest {
	public QueryParameters param = new QueryParameters();

	@Test(enabled = true, description = "Verify Earth close-approach sorted data by distance in Descending Order")
	public void TestEarthCloseApproachSortedDescending() throws IOException {

		// De-serialization of Response
		ResponsePojo data = apiActions.getEarthCloseApproachSortDesc().getBody().as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());

		List<Fields> fields = Utils.extractAndSetFields(data);
		List<BigDecimal> listOfDist = new ArrayList<BigDecimal>();
		for (int i = 0; i < fields.size(); i++) {
			listOfDist.add(fields.get(i).getDist());

		}
		boolean result = CommonFunctions.verifySortedData(listOfDist, 1);
		assertTrue(result, "Dist values are not in descending order");

	}

	@Test(enabled = true, description = "Verify Earth close-approach sorted data by distance in Ascending Order")
	public void TestEarthCloseApproachSortedAscending() throws IOException {

		// De-serialization of Response
		ResponsePojo data = apiActions.getEarthCloseApproachSortAsc().getBody().as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());

		List<Fields> fields = Utils.extractAndSetFields(data);
		List<BigDecimal> listOfDist = new ArrayList<BigDecimal>();
		for (int i = 0; i < fields.size(); i++) {
			listOfDist.add(fields.get(i).getDist());

		}
		boolean result = CommonFunctions.verifySortedData(listOfDist, -1);
		assertTrue(result, "Dist values are not in ascending order");

	}

	
	@Test(description="Need to Fix")
	public void TestEarthCloseApproachAsteroidBetweenDateRange() throws IOException, ParseException {
		String dateMin = "2021-01-01";
		String dateMax = "2021-02-01";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");

		// Checking response is having at least one record
		ResponsePojo data = apiActions.getEarthCloseApproachSortAsc().getBody().as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());

		List<Fields> fields = Utils.extractAndSetFields(data);
		for (int i = 0; i < fields.size(); i++) {
			Date convertedDate = sdf.parse(fields.get(i).getCd());
			String date1 = sdf.format(convertedDate);
			System.out.println(date1);
			
			long yearOfCloseApproach = Long.parseLong(date1.substring(0, 4));
			boolean monthOfCloseApproach = date1.substring(5, 8) == "Jan";
			System.out.println(Integer.parseInt(dateMin.substring(0, 4)) +""+(yearOfCloseApproach > Long.parseLong(dateMin.substring(0, 4).trim())));
			assertTrue("time of close-approach is less than Min Date",
					yearOfCloseApproach > Long.parseLong(dateMin.substring(0, 4)));
			assertTrue("time of close-approach is greater than Max Date",
					yearOfCloseApproach < Integer.parseInt(dateMax.substring(0, 4)) || !monthOfCloseApproach);

		}

	}
}
