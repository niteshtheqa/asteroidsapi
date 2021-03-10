/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package base;

import io.restassured.RestAssured;

/**
 * @author nites
 *
 */
public class Base {

	public Base() {
		RestAssured.baseURI = "https://ssd-api.jpl.nasa.gov/cad.api";

	}
}
