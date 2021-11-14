package com.braindatawire.collegemanagement.model;

public class Student {

	private int sid;
	private String sname;
	private Batch batch;
	private double fees;
	private double feespaid;
	private double feesbal;
	
	public void payFees(double amnt){
		this.feespaid = feespaid + amnt;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public double getFeesbal() {
		this.feesbal = this.fees - this.feespaid; 
		return feesbal;
	}
	public void setFeesbal(double feesbal) {
		this.feesbal = feesbal;
	}
	public double getFeespaid() {
		return feespaid;
	}
	public void setFeespaid(double feespaid) {
		this.feespaid = feespaid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Batch getBatch() {
		return batch;
	}
	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	
}
