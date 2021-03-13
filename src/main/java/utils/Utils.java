/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;

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

	public static String getJsonElement(Response response, String key) {
		JsonPath jsonPath = new JsonPath(response.asString());

		return jsonPath.get(key).toString();
	}

	public static HashMap<String, String> getJsonElementFromNestedJson(Response response, String key) {
		JsonPath jsonPath = new JsonPath(response.asString());
		HashMap<String, String> signatureArray = jsonPath.get(key);
		return signatureArray;
	}

	public static List<?> getElementFromJsonArray(Response response, String key) {

		JsonPath jsonPath = response.jsonPath();
		
		List<?> jsonArray = jsonPath.getList(key);

		return jsonArray;

	}

	public static void parseObject(JSONObject json, String key) {
		System.out.println(json.get(key));
	}

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
					// TODO: handle exception
				}

			}

		} else {
			parseObject(json, key);
		}

	}

	public static JSONObject convertToJSONObject(String string) {
		JSONObject jsonObject = new JSONObject(string);
		return jsonObject;

	}

}
