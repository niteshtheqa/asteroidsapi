
package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.Fields;
import pojo.ResponsePojo;

/**
 * @author Nitesh Wayafalkar
 * @Project Title SBDB - API Automation
 * 
 *          This is Utility class. All utility methods with static modifiers.
 *          This is having methods to read JSON key, extract data from Response
 *          to validate different element based on requirement
 */
public class Utils {

	static final Properties Log4j = new Properties();
	public static Logger LOGGER = Logger.getLogger(Utils.class);

	/**
	 * @return Property object
	 * 
	 *         This loads properties file
	 */
	public static Properties loadProperties() {
		String PATH = Paths.get("./src/main/java/configurations/config.properties").toAbsolutePath().normalize()
				.toString();
		Properties prop = new Properties();
		FileInputStream fileInputStream = null;
		;
		try {
			fileInputStream = new FileInputStream(PATH);
		} catch (FileNotFoundException e1) {

			LOGGER.error("File not found at given location" + e1.getMessage());
		}
		try {
			prop.load(fileInputStream);
		} catch (IOException e) {

			LOGGER.error("Permission denied to read file" + e.getMessage());
		}
		return prop;
	}

	/**
	 * @param key
	 * @return
	 * 
	 * 		This method allows user to read data stored in key-value format
	 */
	public static String getConfigs(String key) {
		String config = null;
		try {
			config = loadProperties().getProperty(key);
		} catch (Exception e) {

			LOGGER.error("Permission denied to read file" + e.getMessage());
		}
		return config;
	}

	/**
	 * @param response
	 * @param key
	 * @return
	 * 
	 * 		This is rad JSON element from response
	 */
	public static String getJsonElement(Response response, String key) {
		String element = null;
		try {
			JsonPath jsonPath = new JsonPath(response.asString());

			element = jsonPath.get(key).toString();
		} catch (NullPointerException e) {
			LOGGER.error("Key did not find in response" + e.getMessage());
		}

		return element;
	}

	/**
	 * @param response
	 * @param key
	 * @return This is use to retrieve JSON Element from JSON ARRAY
	 */
	public static List<?> getElementFromJsonArray(Response response, String key) {

		JsonPath jsonPath = response.jsonPath();

		List<?> jsonArray = jsonPath.getList(key);

		return jsonArray;

	}

	/**
	 * @param json
	 * @param key
	 * 
	 *             This method parse JSON element from JSONObject
	 */
	public static void parseObject(JSONObject json, String key) {
		System.out.println(json.get(key));
	}

	/**
	 * @param json
	 * @param key
	 * 
	 *             This method use to retrieve JSON element from Complex JSON
	 *             Response
	 */
	public static void getKey(JSONObject json, String key) {

		boolean exists = json.has(key);
		Iterator<?> keys;
		String nextKeys;

		if (!exists) {
			keys = json.keys();
			while (keys.hasNext()) {
				nextKeys = (String) keys.next();
				try {

					if (json.get(nextKeys) instanceof JSONObject) {

						if (exists == false) {
							getKey(json.getJSONObject(nextKeys), key);
						}

					} else if (json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray = json.getJSONArray(nextKeys);
						for (int i = 0; i < jsonarray.length(); i++) {
							String jsonarrayString = jsonarray.get(i).toString();
							JSONObject innerJSOn = new JSONObject(jsonarrayString);

							if (exists == false) {
								getKey(innerJSOn, key);
							}

						}

					}

				} catch (Exception e) {

				}

			}

		} else {
			parseObject(json, key);
		}

	}

	/**
	 * @param string
	 * @return
	 */
	public static JSONObject convertToJSONObject(String string) {
		JSONObject jsonObject = new JSONObject(string);
		return jsonObject;

	}

	/**
	 * @param response
	 * @return
	 * 
	 * 		This method uses the concept of De-serialization and set values from
	 *         Response to fields
	 */
	public static List<Fields> extractAndSetFields(ResponsePojo response) {
		List<Fields> apiRes = new ArrayList<Fields>();

		int dataSize = response.getData().size();
		Fields fields;

		try {
			for (int i = 0; i < dataSize; i++) {
				fields = new Fields();
				int arrSize = response.getData().get(i).size() - 1;

				if ((arrSize >= 0)) {
					fields.setDes(response.getData().get(i).get((0)));
				}
				if ((arrSize >= 1)) {
					fields.setOrbitId(response.getData().get(i).get((1)));
				}
				if ((arrSize >= 2)) {
					fields.setJd(response.getData().get(i).get(2));
				}
				if ((arrSize >= 3)) {
					fields.setCd(response.getData().get(i).get(3));
				}
				if ((arrSize >= 4)) {
					fields.setDist(BigDecimal.valueOf(Double.parseDouble(response.getData().get(i).get(4))));
				}
				if ((arrSize >= 5)) {
					fields.setDistMin(BigDecimal.valueOf(Double.parseDouble(response.getData().get(i).get(5))));
				}
				if ((arrSize >= 6)) {
					fields.setDistMax(BigDecimal.valueOf(Double.parseDouble(response.getData().get(i).get(6))));
				}
				if ((arrSize >= 7)) {
					fields.setvRel(response.getData().get(i).get(7));
				}
				if ((arrSize >= 8)) {
					fields.setvInf(response.getData().get(i).get(8));
				}
				if ((arrSize >= 9)) {
					fields.settSigmaF(response.getData().get(i).get((9)));
				}
				if ((arrSize >= 10)) {
					fields.setH(response.getData().get(i).get((10)));
				}
				if ((arrSize >= 11 && response.getData().get(i).get(11) != null)) {
					fields.setDiameter(Double.parseDouble(response.getData().get(i).get(11)));
				}
				if ((arrSize >= 12 && response.getData().get(i).get(12) != null)) {
					fields.setDiameterSigma(Double.parseDouble(response.getData().get(i).get(12)));
				}
				apiRes.add(fields);

			}
		} catch (IndexOutOfBoundsException e) {
			LOGGER.error("Response is empty" + e.getMessage());
		} catch (NumberFormatException e) {
			LOGGER.error("Expected BigDecimal or Double data type" + e.getMessage());
		} catch (NullPointerException e) {
			LOGGER.error("Did not received value " + e.getMessage());
		}

		return apiRes;
	}

}
