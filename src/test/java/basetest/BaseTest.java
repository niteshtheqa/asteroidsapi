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
	public String baseURIHelloSvc;
	public String responseStr;

	static final Properties Log4j = new Properties();
	public static Logger LOGGER = Logger.getLogger(CommonFunctions.class);

	static {
		try {

			String log4jConfPath = Paths.get("./src/main/resources/log4j.properties").toAbsolutePath().normalize()
					.toString();
			// loading log4j properties file
			Log4j.load(new FileInputStream(log4jConfPath));

			PropertyConfigurator.configure(Log4j);
			LOGGER.info("Logger initiated successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeMethod()
	public void setUp() throws IOException {
		apiActions = new APIActions();
		LOGGER.info("Test execution started...");
		Utils.loadProperties();
		RestAssured.baseURI = Utils.getConfigs("baseURI");

		// configs for hello service
		baseURIHelloSvc = "http://127.0.0.1:" + Utils.getConfigs("port") + "/";
		responseStr = "Hi there, !";
		RestAssured.baseURI = baseURIHelloSvc;

	}

	@AfterMethod()
	public void tearDown() {
		LOGGER.info("Test execution completed...");

	}
}
