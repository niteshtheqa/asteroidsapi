/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package basetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import api.actions.APIActions;
import commons.CommonFunctions;
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

	static final Properties Log4j = new Properties();
	public static Logger LOGGER = Logger.getLogger(CommonFunctions.class);

	static {
		try {

			String log4jConfPath = Paths.get("./src/main/java/configurations/log4j.properties").toAbsolutePath()
					.normalize().toString();
			// loading log4j properties file
			Log4j.load(new FileInputStream(log4jConfPath));

			PropertyConfigurator.configure(Log4j);
			LOGGER.info("Logger initiated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BaseTest() {
		RestAssured.baseURI = "https://ssd-api.jpl.nasa.gov/cad.api";

	}

	@BeforeMethod()
	public void setUp() throws IOException {
		apiActions = new APIActions();
		LOGGER.info("Test execution started...");
		Utils.loadProperties();

	}

	@AfterMethod()
	public void tearDown() {
		LOGGER.info("Test execution completed...");

	}
}
