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
		//0.2000000000000000
		//0.174073164088667
		BigDecimal bdNum1 = new BigDecimal(0.174073164088667);
		bdNum1 = bdNum1.setScale(16, BigDecimal.ROUND_HALF_UP);
		System.out.println(bdNum1.compareTo(new BigDecimal(0.2000000000000000)));

	}

}
