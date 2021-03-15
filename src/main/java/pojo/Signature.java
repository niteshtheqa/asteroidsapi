
package pojo;

/**
 * @author Nitesh Wayafalkar
 * @Project Title SBDB - API Automation
 * 
 * 
 *          This is POJO class to read Signature Response and use to set the values as
 *          well as read the value from De-Serialized response
 * 
 */
public class Signature {
	private String source;
	private double version;

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the version
	 */
	public double getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(double version) {
		this.version = version;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Signature [source=" + source + ", version=" + version + ", getSource()=" + getSource()
				+ ", getVersion()=" + getVersion() + "]";
	}

}
