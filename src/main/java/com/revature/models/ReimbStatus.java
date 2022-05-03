package com.revature.models;

public class ReimbStatus {
	private int status_id;
	private String status;
	
	public ReimbStatus() {
		super();
	}
	
	public ReimbStatus(String status) {
		super();
		this.status = status;
	}
	
	public ReimbStatus(int statusID, String status) {
		super();
		this.status_id = statusID;
		this.status = status;
	}
	
	public int getStatusID() {
		return status_id;
	}
	
	public String getReimbStatus() {
		return status;
	}
	
	public void setStatusID(int id) {
		this.status_id = id;
	}
	
	public void setReimbStatus(String type) {
		this.status = type;
	}
	
	@Override
	public String toString() {
		return "Reimbursement Status ID = " + status_id + ", Reimbursement Status = " + status;
	}

}