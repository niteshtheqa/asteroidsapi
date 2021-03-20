
package commons;

import org.testng.annotations.DataProvider;

/**
 * @author Nitesh Wayafalkar
 * @Project Title SBDB - API Automation This class is use as data provider to
 *          calling test method
 */
public class DataProviderImpl {

	/**
	 * @return Object array and provide to intended method
	 */
	@DataProvider(name = "DesignationProvider")
	public Object[][] getDataFromDataprovider() {
		return new Object[][] { { "141P", "K202/3" }, { "433", "658" } };

	}
}
