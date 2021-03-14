/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package specifications;

import java.io.IOException;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.Utils;

/**
 * @author nitesh Wayafalkar
 * 
 *
 */
public class Builders {
	public RequestSpecification req;
	public ResponseSpecification res;

	public RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			//PrintStream stream = new PrintStream(new FileOutputStream("log.txt"));
			req = new RequestSpecBuilder().setBaseUri(Utils.getConfigs("baseURI")).setContentType(ContentType.JSON)
					.build();
			return req;
			// .addFilter(ResponseLoggingFilter.responseLogger())
		}
		return req;

	}

	public ResponseSpecification responseSpecification() throws IOException {

		res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return res;

	}

}
