package com.revature.models;

public class User {
	private int user_id;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private UserRole user_role;
	
	
	public User() {
		super();
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(int userID, String username, String password) {
		super();
		this.user_id = userID;
		this.username = username;
		this.password = password;
	}
	
	public User(int userID, String username, String password, UserRole userRole) {
		super();
		this.user_id = userID;
		this.username = username;
		this.password = password;
		this.user_role = userRole;
	}
	
	public User(String firstName, String lastName, String email) {
		super();
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
	}
	
	public User(int userID, String firstName, String lastName, String email) {
		super();
		this.user_id = userID;
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
	}
	
	public User(int userID, String firstName, String lastName, String email, UserRole userRole) {
		super();
		this.user_id = userID;
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
		this.user_role = userRole;
	}
	
	public User(int userID, String username, String password, String firstName, String lastName, String email, UserRole userRole) {
		super();
		this.user_id = userID;
		this.username = username;
		this.password = password;
		this.first_name = firstName;
		this.last_name = lastName;
		this.email = email;
		this.user_role = userRole;
	}
	
	public int getUserID() {
		return user_id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public UserRole getUserRole() {
		return user_role;
	}
	
	public void setUserID(int userID) {
		this.user_id = userID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}
	
	public void setLastName(String lastName) {
		this.last_name = lastName;
	}
	 
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUserRole(UserRole userRole) {
		this.user_role = userRole;
	}
	
	@Override
	public String toString() {
		return "User ID = " + user_id + ", First Name = " + first_name + ", Last Name = " + last_name + ", Email = " + email + ", Username = " + username + ", Password = " + password + ", " + user_role.toString();
	}
 
}
