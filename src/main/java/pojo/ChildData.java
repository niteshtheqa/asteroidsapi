/**
 * @author Nitesh Wayafalkar
 * @Project Title  AutomationPractice
 * 
 */
package pojo;

import java.math.BigDecimal;

/**
 * @author nites
 *
 */
public class ChildData {
	
	private String des;
	private String orbit_id;
	private String jd;
	private String cd;
	private BigDecimal dist;
	private BigDecimal dist_min;
	private BigDecimal dist_max;
	private String v_rel;
	private String v_inf;
	private String t_sigma_f;
	private int h;
	private String diameter;
	private boolean diameter_sigma;
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
	 * @return the orbit_id
	 */
	public String getOrbit_id() {
		return orbit_id;
	}
	/**
	 * @param orbit_id the orbit_id to set
	 */
	public void setOrbit_id(String orbit_id) {
		this.orbit_id = orbit_id;
	}
	/**
	 * @return the jd
	 */
	public String getJd() {
		return jd;
	}
	/**
	 * @param jd the jd to set
	 */
	public void setJd(String jd) {
		this.jd = jd;
	}
	/**
	 * @return the cd
	 */
	public String getCd() {
		return cd;
	}
	/**
	 * @param cd the cd to set
	 */
	public void setCd(String cd) {
		this.cd = cd;
	}
	/**
	 * @return the dist
	 */
	public BigDecimal getDist() {
		return dist;
	}
	/**
	 * @param dist the dist to set
	 */
	public void setDist(BigDecimal dist) {
		this.dist = dist;
	}
	/**
	 * @return the dist_min
	 */
	public BigDecimal getDist_min() {
		return dist_min;
	}
	/**
	 * @param dist_min the dist_min to set
	 */
	public void setDist_min(BigDecimal dist_min) {
		this.dist_min = dist_min;
	}
	/**
	 * @return the dist_max
	 */
	public BigDecimal getDist_max() {
		return dist_max;
	}
	/**
	 * @param dist_max the dist_max to set
	 */
	public void setDist_max(BigDecimal dist_max) {
		this.dist_max = dist_max;
	}
	/**
	 * @return the v_rel
	 */
	public String getV_rel() {
		return v_rel;
	}
	/**
	 * @param v_rel the v_rel to set
	 */
	public void setV_rel(String v_rel) {
		this.v_rel = v_rel;
	}
	/**
	 * @return the v_inf
	 */
	public String getV_inf() {
		return v_inf;
	}
	/**
	 * @param v_inf the v_inf to set
	 */
	public void setV_inf(String v_inf) {
		this.v_inf = v_inf;
	}
	/**
	 * @return the t_sigma_f
	 */
	public String getT_sigma_f() {
		return t_sigma_f;
	}
	/**
	 * @param t_sigma_f the t_sigma_f to set
	 */
	public void setT_sigma_f(String t_sigma_f) {
		this.t_sigma_f = t_sigma_f;
	}
	/**
	 * @return the h
	 */
	public int getH() {
		return h;
	}
	/**
	 * @param h the h to set
	 */
	public void setH(int h) {
		this.h = h;
	}
	/**
	 * @return the diameter
	 */
	public String getDiameter() {
		return diameter;
	}
	/**
	 * @param diameter the diameter to set
	 */
	public void setDiameter(String diameter) {
		this.diameter = diameter;
	}
	/**
	 * @return the diameter_sigma
	 */
	public boolean isDiameter_sigma() {
		return diameter_sigma;
	}
	/**
	 * @param diameter_sigma the diameter_sigma to set
	 */
	public void setDiameter_sigma(boolean diameter_sigma) {
		this.diameter_sigma = diameter_sigma;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Data [des=" + des + ", orbit_id=" + orbit_id + ", jd=" + jd + ", cd=" + cd + ", dist=" + dist
				+ ", dist_min=" + dist_min + ", dist_max=" + dist_max + ", v_rel=" + v_rel + ", v_inf=" + v_inf
				+ ", t_sigma_f=" + t_sigma_f + ", h=" + h + ", diameter=" + diameter + ", diameter_sigma="
				+ diameter_sigma + ", getDes()=" + getDes() + ", getOrbit_id()=" + getOrbit_id() + ", getJd()="
				+ getJd() + ", getCd()=" + getCd() + ", getDist()=" + getDist() + ", getDist_min()=" + getDist_min()
				+ ", getDist_max()=" + getDist_max() + ", getV_rel()=" + getV_rel() + ", getV_inf()=" + getV_inf()
				+ ", getT_sigma_f()=" + getT_sigma_f() + ", getH()=" + getH() + ", getDiameter()=" + getDiameter()
				+ ", isDiameter_sigma()=" + isDiameter_sigma() + "]";
	}
	
	
	

}
