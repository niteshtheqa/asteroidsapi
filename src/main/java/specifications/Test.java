/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package specifications;

import java.math.BigDecimal;

/**
 * @author nites
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double lon = 0.2000000000000000;
		BigDecimal bdLon = new BigDecimal(lon);
		bdLon = bdLon.setScale(16, BigDecimal.ROUND_HALF_UP);
		System.out.println(bdLon.doubleValue() > 0.174073164088667);
		

	}

}
