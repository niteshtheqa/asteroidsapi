/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package basetest;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import api.actions.APIActions;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.Utils;

/**
 * @author nites
 *
 */
public class BaseTest {
	public APIActions apiActions;
	public Response response;
	

	public BaseTest() {
		RestAssured.baseURI = "https://ssd-api.jpl.nasa.gov/cad.api";

	}
	
	
	@BeforeMethod()
	public void setUp() throws IOException {
		apiActions = new APIActions();
		Reporter.log("Test execution started...");
		Utils.loadProperties();

	}
	
	@AfterMethod()
	public void tearDown() {
		Reporter.log("Test execution completed...");
	}
}
