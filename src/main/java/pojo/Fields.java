
package pojo;

import java.math.BigDecimal;

/**
 * @author Nitesh Wayafalkar
 * @Project Title SBDB - API Automation
 * 
 * This is POJO class for fields from Response and use to set the values as well as read the value from De-Serialized response
 * 
 */
public class Fields {

	private String des;
	private String orbitId;
	private String jd;
	private String cd;
	private BigDecimal dist;
	private BigDecimal distMin;
	private BigDecimal distMax;
	private String vRel;
	private String vInf;
	private String tSigmaF;
	private String h;
	private double diameter;
	private double diameterSigma;
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
	 * @return the orbitId
	 */
	public String getOrbitId() {
		return orbitId;
	}
	/**
	 * @param orbitId the orbitId to set
	 */
	public void setOrbitId(String orbitId) {
		this.orbitId = orbitId;
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
	 * @return the distMin
	 */
	public BigDecimal getDistMin() {
		return distMin;
	}
	/**
	 * @param distMin the distMin to set
	 */
	public void setDistMin(BigDecimal distMin) {
		this.distMin = distMin;
	}
	/**
	 * @return the distMax
	 */
	public BigDecimal getDistMax() {
		return distMax;
	}
	/**
	 * @param distMax the distMax to set
	 */
	public void setDistMax(BigDecimal distMax) {
		this.distMax = distMax;
	}
	/**
	 * @return the vRel
	 */
	public String getvRel() {
		return vRel;
	}
	/**
	 * @param vRel the vRel to set
	 */
	public void setvRel(String vRel) {
		this.vRel = vRel;
	}
	/**
	 * @return the vInf
	 */
	public String getvInf() {
		return vInf;
	}
	/**
	 * @param vInf the vInf to set
	 */
	public void setvInf(String vInf) {
		this.vInf = vInf;
	}
	/**
	 * @return the tSigmaF
	 */
	public String gettSigmaF() {
		return tSigmaF;
	}
	/**
	 * @param tSigmaF the tSigmaF to set
	 */
	public void settSigmaF(String tSigmaF) {
		this.tSigmaF = tSigmaF;
	}
	/**
	 * @return 
	 * @return the h
	 */
	public  String getH() {
		return h;
	}
	/**
	 * @param h the h to set
	 */
	public void setH(String h) {
		this.h = h;
	}
	
	/**
	 * @return the diameter
	 */
	public double getDiameter() {
		return diameter;
	}
	/**
	 * @param diameter the diameter to set
	 */
	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}
	/**
	 * @return the diameterSigma
	 */
	public double getDiameterSigma() {
		return diameterSigma;
	}
	/**
	 * @param diameterSigma the diameterSigma to set
	 */
	public void setDiameterSigma(double diameterSigma) {
		this.diameterSigma = diameterSigma;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fields [des=" + des + ", orbitId=" + orbitId + ", jd=" + jd + ", cd=" + cd + ", dist=" + dist
				+ ", distMin=" + distMin + ", distMax=" + distMax + ", vRel=" + vRel + ", vInf=" + vInf + ", tSigmaF="
				+ tSigmaF + ", h=" + h + ", diameter=" + diameter + ", diameterSigma=" + diameterSigma + ", getDes()="
				+ getDes() + ", getOrbitId()=" + getOrbitId() + ", getJd()=" + getJd() + ", getCd()=" + getCd()
				+ ", getDist()=" + getDist() + ", getDistMin()=" + getDistMin() + ", getDistMax()=" + getDistMax()
				+ ", getvRel()=" + getvRel() + ", getvInf()=" + getvInf() + ", gettSigmaF()=" + gettSigmaF()
				+ ", getH()=" + getH() + ", getDiameter()=" + getDiameter() + ", isDiameterSigma()=" + getDiameterSigma()
				+ "]";
	}

	
	

}
