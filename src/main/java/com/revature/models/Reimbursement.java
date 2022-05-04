package com.revature.models;


public class Reimbursement {
	private int reimb_id;
	private int reimb_amount;
	private String reimb_submitted;
	private String reimb_resolved;
	private String reimb_description;
	private User author;
	private User resolver;
	private ReimbStatus reimb_status;
	private ReimbType reimb_type;
	
	public Reimbursement() {
		super();
	}
	
	public Reimbursement(int reimbAmount, String reimbSubmitDate, String reimbResolveDate, String description) {
		super();
		this.reimb_amount = reimbAmount;
		this.reimb_submitted = reimbSubmitDate;
		this.reimb_resolved = reimbResolveDate;
		this.reimb_description = description;
	}
	
	public Reimbursement(int reimbID, int reimbAmount, String reimbSubmitDate, String reimbResolveDate, String description, User author, ReimbStatus reimbStatus, ReimbType reimbType) {
		super();
		this.reimb_id = reimbID;
		this.reimb_amount = reimbAmount;
		this.reimb_submitted = reimbSubmitDate;
		this.reimb_resolved = reimbResolveDate;
		this.reimb_description = description;
		this.author = author;
		this.reimb_status = reimbStatus;
		this.reimb_type = reimbType;

	}
	
	public Reimbursement(int reimbID, int reimbAmount, String reimbSubmitDate, String reimbResolveDate, String description, User author, User resolver, ReimbStatus reimbStatus, ReimbType reimbType) {
		super();
		this.reimb_id = reimbID;
		this.reimb_amount = reimbAmount;
		this.reimb_submitted = reimbSubmitDate;
		this.reimb_resolved = reimbResolveDate;
		this.reimb_description = description;
		this.author = author;
		this.resolver = resolver;
		this.reimb_status = reimbStatus;
		this.reimb_type = reimbType;

	}
	
	public int getReimbID() {
		return reimb_id;
	}
	
	public int getReimbAmount() {
		return reimb_amount;
	}
	
	public String getReimbSubmitDate() {
		return reimb_submitted;
	}
	
	public String getReimbResolveDate() {
		return reimb_resolved;
	}
	
	public String getReimbDescription() {
		return reimb_description;
	}
	
	public User getReimbAuthor() {
		return author;
	}
	
	public User getReimbResolver() {
		return resolver;
	}
	
	public ReimbStatus getReimbStatus() {
		return reimb_status;
	}
	
	public ReimbType getReimbType() {
		return reimb_type;
	}
	
	public void setReimbID(int id) {
		this.reimb_id = id;
	}
	
	public void setReimbSubmitDate(String submitDate) {
		this.reimb_submitted = submitDate;
	}
	
	public void setReimbResolveDate(String resolveDate) {
		this.reimb_resolved = resolveDate;
	}
	
	public void setReimbDescription(String description) {
		this.reimb_description = description;
	}
	
	public void setReimbAuthor(User author) {
		this.author = author;
	}
	
	public void setReimbResolver(User resolver) {
		this.resolver = resolver;
	}
	
	@Override
	public String toString() {
		return "Reimbursement ID = " + reimb_id + ", Reimbursement Amount = " + reimb_amount + ", Reimbursement Submit Date = " + reimb_submitted + ", Reimbursement Reolve Date = " + 
				reimb_resolved + ", Reimbursement Description = " + reimb_description + ", Reimbursement Ticket Author = " + author.getFirstName() + " " + author.getLastName() + " " + 
				author.getEmail() + ", Reimbursement Ticket Resolver = " + resolver.getFirstName() + " " + resolver.getLastName() + " " + resolver.getEmail();
	}
	
	

}
