/**
 * @author Nitesh Wayafalkar
 * @Project Title  SBDB-API Automation
 * 
 */
package hellosvctest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import basetest.BaseTest;
import reporter.ExtentReporter;

/**
 * @author nites
 *
 * 
 */

@Listeners(ExtentReporter.class)
public class TestHelloService extends BaseTest {




	@Test()
	public void verifyHelloServiceUpAndRunning() {

		given().log().all().when().get().then().log().all().assertThat().statusCode(200).and()
				.body(equalTo(responseStr));

	}

	@Test()
	public void verifyHelloSvcGivesResponseWithSingleWord() {
		String param = "MyHelloService";
		String expectedStr = "Hi there, " + param + "" + "!";
		given().log().all().when().get(param).then().log().all().assertThat().statusCode(200).and()
				.body(equalTo(expectedStr));
	}

	@Test()
	public void verifyHelloSvcRevertsNumericString() {
		String param = "12345 635863508670";
		String expectedStr = "Hi there, " + param + "" + "!";
		given().log().all().when().get(param).then().log().all().assertThat().statusCode(200).and()
				.body(equalTo(expectedStr));
	}

	@Test()
	public void verifyHelloSvcReturnsWholeString() {
		String param = "Nitesh Wayafalkar";
		String expectedStr = "Hi there, " + param + "" + "!";
		given().log().all().when().get(param).then().log().all().assertThat().statusCode(200).and()
				.body(equalTo(expectedStr));
	}

	@Test()
	public void verifyHelloSvcShouldNotBreakForEmptyString() {

		given().log().all().when().get(" ").then().log().all().assertThat().statusCode(200).and()
				.body(equalTo("Hi there, !"));
	}

}
