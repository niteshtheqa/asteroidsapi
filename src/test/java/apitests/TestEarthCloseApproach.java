
package apitests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basetest.BaseTest;
import commons.CommonFunctions;
import commons.QueryParameters;
import pojo.Fields;
import pojo.ResponsePojo;
import reporter.ExtentReporter;
import utils.Utils;

/**
 * @author Nitesh Wayafalkar
 * @Project Title SBDB - API Automation
 * 
 */

@Listeners(ExtentReporter.class)
public class TestEarthCloseApproach extends BaseTest {

	static final Properties Log4j = new Properties();
	public static Logger LOGGER = Logger.getLogger(TestEarthCloseApproach.class);

	public QueryParameters param = new QueryParameters();


	@Test(priority = 0, description = "Verify Earth close-approach data is not NULL/Empty")
	public void VerifyEarthCloseApproachAsteroidResponseIsNotNull() throws IOException {
		String sort = "-dist";

		ResponsePojo data = apiActions.getEarthCloseApproachSort(sort).getBody().as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());

	}

	@Test(priority = 1, description = "Verify Earth close-approach Signature is valid")
	public void VerifyEarthCloseApproachAsteroidResponseSignatureIsValid() throws IOException {
		String sort = "-dist";

		ResponsePojo data = apiActions.getEarthCloseApproachSort(sort).getBody().as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());

	}

	@Test(dependsOnMethods = "VerifyEarthCloseApproachAsteroidResponseSignatureIsValid", enabled = true, description = "Verify Earth close-approach sorted data by distance in Descending Order")
	public void TestEarthCloseApproachSortedDescending() throws IOException {

		String sort = "-dist";
		boolean result = false;
		// De-serialization of Response
		ResponsePojo data = apiActions.getEarthCloseApproachSort(sort).getBody().as(ResponsePojo.class);
		CommonFunctions.assertCount(data.getCount());
		CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());

		List<Fields> fields = Utils.extractAndSetFields(data);
		try {

			List<BigDecimal> listOfDist = new ArrayList<BigDecimal>();
			for (int i = 0; i < fields.size(); i++) {
				listOfDist.add(fields.get(i).getDist());
			}
			result = CommonFunctions.verifySortedData(listOfDist, 1);
		} catch (NumberFormatException e) {
			LOGGER.error("Expecting data type as BigDecimal" + e.getLocalizedMessage());
		}

		assertTrue(result, "Data is not in descending order");

	}

	@Test(dependsOnMethods = "VerifyEarthCloseApproachAsteroidResponseSignatureIsValid", enabled = true, description = "Verify Earth close-approach sorted data by distance in Ascending Order")
	public void TestEarthCloseApproachSortedAscending() throws IOException {
		String sort = "dist";
		try {
			boolean result = false;
			// De-serialization of Response
			ResponsePojo data = apiActions.getEarthCloseApproachSort(sort).getBody().as(ResponsePojo.class);
			CommonFunctions.assertCount(data.getCount());
			CommonFunctions.assertSignature(data.getSignature().getSource(), data.getSignature().getVersion());

			List<Fields> fields = Utils.extractAndSetFields(data);

			List<BigDecimal> listOfDist = new ArrayList<BigDecimal>();
			for (int i = 0; i < fields.size(); i++) {
				listOfDist.add(fields.get(i).getDist());

			}
			result = CommonFunctions.verifySortedData(listOfDist, -1);
			assertTrue(result, "Data is not in ascending order");
		} catch (NumberFormatException e) {
			LOGGER.error("Expecting data type as BigDecimal" + e.getLocalizedMessage());
		}

	}

}
