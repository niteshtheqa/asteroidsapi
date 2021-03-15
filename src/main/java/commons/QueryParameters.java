
package commons;

/**
 * @author Nitesh Wayafalkar
 * @Project Title SBDB - API Automation
 * 
 *          This is POJO class for Query Parameters. It is used to set the
 *          values to query parameter at runtime and return values with the help
 *          of getters methods
 */

public class QueryParameters {

	private String des;
	private String dist;
	private String distMin;
	private String distMax;
	private String dateMin;
	private String dateMax;
	private String sort;
	private int h_min;
	private int h_max;
	private String class_;

	/**
	 * @return the des
	 */
	public String getDes() {
		return des;
	}

	/**
	 * @param des the des to set
	 */
	public void setDes(String des) {
		this.des = des;
	}

	/**
	 * @return the dist
	 */
	public String getDist() {
		return dist;
	}

	/**
	 * @param dist the dist to set
	 */
	public void setDist(String dist) {
		this.dist = dist;
	}

	/**
	 * @return the distMin
	 */
	public String getDistMin() {
		return distMin;
	}

	/**
	 * @param distMin the distMin to set
	 */
	public void setDistMin(String distMin) {
		this.distMin = distMin;
	}

	/**
	 * @return the distMax
	 */
	public String getDistMax() {
		return distMax;
	}

	/**
	 * @param distMax the distMax to set
	 */
	public void setDistMax(String distMax) {
		this.distMax = distMax;
	}

	/**
	 * @return the dateMin
	 */
	public String getDateMin() {
		return dateMin;
	}

	/**
	 * @param dateMin the dateMin to set
	 */
	public void setDateMin(String dateMin) {
		this.dateMin = dateMin;
	}

	/**
	 * @return the dateMax
	 */
	public String getDateMax() {
		return dateMax;
	}

	/**
	 * @param dateMax the dateMax to set
	 */
	public void setDateMax(String dateMax) {
		this.dateMax = dateMax;
	}

	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return the h_min
	 */
	public int getH_min() {
		return h_min;
	}

	/**
	 * @param h_min the h_min to set
	 */
	public void setH_min(int h_min) {
		this.h_min = h_min;
	}

	/**
	 * @return the h_max
	 */
	public int getH_max() {
		return h_max;
	}

	/**
	 * @param h_max the h_max to set
	 */
	public void setH_max(int h_max) {
		this.h_max = h_max;
	}

	/**
	 * @return the class_
	 */
	public String getClass_() {
		return class_;
	}

	/**
	 * @param class_ the class_ to set
	 */
	public void setClass_(String class_) {
		this.class_ = class_;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "QueryParameters [des=" + des + ", dist=" + dist + ", distMin=" + distMin + ", distMax=" + distMax
				+ ", dateMin=" + dateMin + ", dateMax=" + dateMax + ", sort=" + sort + ", h_min=" + h_min + ", h_max="
				+ h_max + ", class_=" + class_ + ", getDes()=" + getDes() + ", getDist()=" + getDist()
				+ ", getDistMin()=" + getDistMin() + ", getDistMax()=" + getDistMax() + ", getDateMin()=" + getDateMin()
				+ ", getDateMax()=" + getDateMax() + ", getSort()=" + getSort() + ", getH_min()=" + getH_min()
				+ ", getH_max()=" + getH_max() + ", getClass_()=" + getClass_() + "]";
	}

}
