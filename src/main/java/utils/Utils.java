/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author nites
 *
 */
public class Utils {
	
	
	public static Properties loadProperties() throws IOException {
		String PATH = Paths.get("./src/main/java/configurations/config.properties").toAbsolutePath().normalize()
				.toString();
		Properties prop = new Properties();
		FileInputStream fileInputStream = new FileInputStream(PATH);
		prop.load(fileInputStream);
		return prop;
	}
	public static String getConfigs(String key) throws IOException {


		return loadProperties().getProperty(key);
	}

	public static String getJsonPath(Response response, String key) {
		JsonPath jsonPath = new JsonPath(response.asString());

		return jsonPath.get(key).toString();
	}

}
