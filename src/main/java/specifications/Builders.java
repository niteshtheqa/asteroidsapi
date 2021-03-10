/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package specifications;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utils.Utils;

/**
 * @author nites
 *
 */
public class Builders {
	static RequestSpecification req;

	public static RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			PrintStream stream = new PrintStream(new FileOutputStream("log.txt"));
			req = new RequestSpecBuilder().setBaseUri(Utils.getConfigs("baseURI"))
					.addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream))
					.setContentType(ContentType.JSON).build();
			return req;
		}
		return req;

	}

}
