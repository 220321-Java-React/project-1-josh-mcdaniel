package com.revature.models;

public class UserRole {
	private int role_id;
	private String role;
	
	public UserRole() {
		super();
	}
	
	public UserRole(String role) {
		super();
		this.role = role;
	}
	
	public UserRole(int roleID, String role) {
		super();
		this.role_id = roleID;
		this.role = role;
	}
	
	public int getRoleID() {
		return this.role_id;
	}
	
	public String getUserRole() {
		return this.role;
	}
	
	public void setRoleID(int roleID) {
		this.role_id = roleID;
	}
	
	public void setUserRole(String role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User Role ID = " + role_id + ", User Role = " + role;
	}
}
