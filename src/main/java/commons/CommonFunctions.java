/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package commons;

import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import pojo.Fields;

/**
 * @author nites
 *
 */
public class CommonFunctions {

	public static void assertCount(int data) {
		assertTrue(data > 0, "No records found");
	}

	public static void assertSignature(String source, double version) {
		assertTrue(version == 1.2 && source.equals("NASA/JPL SBDB Close Approach Data API"), "Invalid Signature");
	}

	public static void assertOrbitIDs(List<Fields> fields, int i, String value) {
		assertTrue(value.equals(fields.get(i).getOrbitId()), "Expected Ordbit Id is not received");
	}


	public static boolean verifySortedData(List<BigDecimal> listOfDist,int order ) {
		
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
			System.out.println("List of Dist is empty");
			return false;
		}
		return false;

	}

}
