
package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Nitesh Wayafalkar
 * @Project Title SBDB - API Automation 
 * 
 * This is POJO class to read Response and
 *          use to set the values as well as read the value from De-Serialized
 *          response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponsePojo {

	private Signature signature;
	private int count;
	private List<Fields> fileds;
	private List<List<String>> data;

	/**
	 * @return the signature
	 */
	public Signature getSignature() {
		return signature;
	}

	/**
	 * @param signature the signature to set
	 */
	public void setSignature(Signature signature) {
		this.signature = signature;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * @return the fileds
	 */
	public List<Fields> getFileds() {
		return fileds;
	}

	/**
	 * @param fileds the fileds to set
	 */
	public void setFileds(List<Fields> fileds) {
		this.fileds = fileds;
	}

	/**
	 * @return the data
	 */
	public List<List<String>> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<List<String>> data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponsePojo [signature=" + signature + ", count=" + count + ", fileds=" + fileds + ", data=" + data
				+ ", getSignature()=" + getSignature() + ", getCount()=" + getCount() + ", getFileds()=" + getFileds()
				+ ", getData()=" + getData() + "]";
	}

}
