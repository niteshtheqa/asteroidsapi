/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package commons;

import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pojo.Fields;
import pojo.ResponsePojo;

/**
 * @author nites
 *
 */
public class CommonFunctions {

	public static void assertCount(int data) {
		assertTrue(data > 0, "No records found");
	}

	public static void assertSignature(String source, double version) {
		assertTrue(version == 1.2 && source.equals("NASA/JPL SBDB Close Approach Data API"), "Invalid Signature");
	}

	public static List<Fields> extractAndSetFields(ResponsePojo response) {
		List<Fields> apiRes = new ArrayList<Fields>();

		int dataSize = response.getData().size();
		for (int i = 0; i < dataSize; i++) {
			Fields fields = new Fields();
			fields.setDes(response.getData().get(i).get(0));
			fields.setOrbitId(response.getData().get(i).get(1));
			fields.setJd(response.getData().get(i).get(2));
			fields.setCd(response.getData().get(i).get(3));
			fields.setDist(BigDecimal.valueOf(Double.parseDouble(response.getData().get(i).get(4))));
			fields.setDistMin(BigDecimal.valueOf(Double.parseDouble(response.getData().get(i).get(5))));
			fields.setDistMax(BigDecimal.valueOf(Double.parseDouble(response.getData().get(i).get(6))));
			fields.setvRel(response.getData().get(i).get(7));
			fields.setvInf(response.getData().get(i).get(8));
			fields.settSigmaF(response.getData().get(i).get(9));
			fields.setH(response.getData().get(i).get(10));
			fields.setDiameter(Double.parseDouble(response.getData().get(i).get(11)));
			fields.setDiameterSigma(Double.parseDouble(response.getData().get(i).get(12)));
			apiRes.add(fields);

		}

		return apiRes;
	}

}
