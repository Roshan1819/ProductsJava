package com.demo.beans;


public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private String uname;
    
    public User(String firstname, String lastname, String email, String phone, String uname, String pass) {
     	this.firstname = firstname;
    	this.lastname = lastname;
    	this.email = email;
    	this.phone = phone;
    	this.uname = uname;
    	this.pass = pass;
		
	}
    public User() {
    	super();
        this.firstname = null;
		this.lastname = null;
		this.email = null;
		this.phone = null;
		this.uname = null;
		this.pass = null;
    }
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	private String pass;
    
     
}
