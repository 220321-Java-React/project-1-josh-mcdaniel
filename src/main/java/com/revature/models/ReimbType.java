package com.revature.models;

public class ReimbType {
	private int type_id;
	private String type;
	
	public ReimbType() {
		super();
	}
	
	public ReimbType(String type) {
		super();
		this.type = type;
	}
	
	public ReimbType(int typeID, String type) {
		super();
		this.type_id = typeID;
		this.type = type;
	}
	
	public int getTypeID() {
		return type_id;
	}
	
	public String getReimbType() {
		return type;
	}
	
	public void setTypeID(int id) {
		this.type_id = id;
	}
	
	public void setReimbType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Reimbursement Type ID = " + type_id + ", Reimbursement Type = " + type;
	}

}
