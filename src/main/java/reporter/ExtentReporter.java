package reporter;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.Utils;

public class ExtentReporter implements IReporter {

	private static String resultpath = getResultPath();
	String ReportLocation = "test-output/" + resultpath + "/";

	public ExtentReports extent;

	private static String getResultPath() {

		resultpath = "Report";
		if (!new File(resultpath).isDirectory()) {
			new File(resultpath);
		}
		return resultpath;
	}

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

		extent = new ExtentReports(ReportLocation + "ExtentReport.html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);

			}
		}

		extent.flush();
		extent.close();
	}

	public void buildTestNodes(IResultMap tests, LogStatus status) {

		ExtentTest test;

		if (tests.size() > 0) {

			for (ITestResult results : tests.getAllResults()) {

				test = extent.startTest(results.getMethod().getMethodName());
				extent.addSystemInfo("User Name", Utils.getConfigs("username"));
				extent.addSystemInfo("Environment", Utils.getConfigs("Environment"));
				extent.addSystemInfo("Project Name", Utils.getConfigs("projectname"));
				extent.loadConfig(new File("./src/main/resources/extent-config.xml"));

				test.setEndedTime(getTime(results.getStartMillis()));
				test.setEndedTime(getTime(results.getEndMillis()));
				for (String group : results.getMethod().getGroups()) {
					test.assignCategory(group);

				}

				if (results.getThrowable() != null) {
					test.log(status, results.getThrowable());
				} else {
					test.log(status, "Test" + status.toString().toLowerCase() + "ed");
				}

				extent.endTest(test);
			}

		}

	}

	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}
