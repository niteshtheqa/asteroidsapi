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
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import utils.Utils;

/**
 * @author nitesh Wayafalkar
 *  
 *  This contains request and response specification methods which allows to define all   specification which need to use frequently in
 *  request or response
 *
 */
public class Builders {
	public RequestSpecification req;
	public ResponseSpecification res;

	/**
	 * @return
	 * @throws IOException
	 * This is request specification which allows to define several specification in advance at time and remove chances of code redundancy
	 */
	public RequestSpecification requestSpecification() throws IOException {
		if (req == null) {
			 PrintStream stream = new PrintStream(new FileOutputStream("apps.logs"));
			req = new RequestSpecBuilder().setBaseUri(Utils.getConfigs("baseURI")).setContentType(ContentType.JSON)
					.log(LogDetail.URI).log(LogDetail.HEADERS).log(LogDetail.PARAMS).addFilter(RequestLoggingFilter.logRequestTo(stream)).build();
			return req;
		}
		return req;

	}

	public ResponseSpecification responseSpecification() throws IOException {

		res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return res;

	}

}
