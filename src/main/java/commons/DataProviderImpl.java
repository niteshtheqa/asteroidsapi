/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package commons;

import org.testng.annotations.DataProvider;

/**
 * @author nites
 *
 */
public class DataProviderImpl {
	@DataProvider(name = "DesignationProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "141P", "K202/2" }, { "433", "658" } };

	}
}
