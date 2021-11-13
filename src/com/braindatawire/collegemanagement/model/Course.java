package com.braindatawire.collegemanagement.model;

public class Course {

	private int cid;
	private String cname;
	private String cType;
	private String cMode;
	private double cFees;
	
		
	
	public double getcFees() {
		return cFees;
	}
	public void setcFees(double cFees) {
		this.cFees = cFees;
	}
	public String getcType() {
		return cType;
	}
	public void setcType(String cType) {
		this.cType = cType;
	}
	public String getcMode() {
		return cMode;
	}
	public void setcMode(String cMode) {
		this.cMode = cMode;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	
}
