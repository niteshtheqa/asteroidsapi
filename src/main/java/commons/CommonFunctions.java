
package commons;

import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

import pojo.Fields;

/**
 * @author Nitesh Wayafalkar
 * @Project Title SBDB - API Automation This class contains all common functions
 *          useful across the framework
 */

public class CommonFunctions {
	static final Properties Log4j = new Properties();
	public static Logger LOGGER = Logger.getLogger(CommonFunctions.class);

	/**
	 * @param data This method asserts whether response is having at least one
	 *             record
	 */
	public static void assertCount(int data) {
		try {
			assertTrue(data > 0);
		} catch (Exception e) {
			LOGGER.error("No records found");
		}
	}

	/**
	 * @param source
	 * @param version
	 * 
	 *                This method asserts Signature received in response Expected
	 *                version is 1.2
	 */
	public static void assertSignature(String source, double version) {
		try {
			assertTrue(version == 1.2 && source.equals("NASA/JPL SBDB Close Approach Data API"));
		} catch (Exception e) {
			LOGGER.error("Signature is invalid");
		}
	}

	/**
	 * @param fields
	 * @param i
	 * @param value
	 * 
	 *               This method asserts Orbit Id's received in response against the
	 *               Designation values
	 */
	public static void assertOrbitIDs(List<Fields> fields, int i, String value) {
		try {
			assertTrue(value.equals(fields.get(i).getOrbitId()));
		} catch (Exception e) {
			LOGGER.error("Expected Ordbit Id is not received");
		}
	}

	/**
	 * @param listOfDist
	 * @param order
	 * @return boolean value showing data is sorted or not
	 * 
	 *         This method asserts Dist's values are sorted in ascending or
	 *         descending order based on order
	 */
	public static boolean verifySortedData(List<BigDecimal> listOfDist, int order) {

		try {
			if (null == listOfDist || listOfDist.size() < 1) {
				return false;
			}

			Iterator<BigDecimal> itr = listOfDist.iterator();
			BigDecimal current, previous = itr.next();
			while (itr.hasNext()) {
				current = itr.next();
				if (previous.compareTo(current) == order) {

					return true;
				}
				previous = current;
			}
		} catch (Exception e) {
			LOGGER.error("List of Dist is empty");
			return false;
		}
		return false;

	}

}
