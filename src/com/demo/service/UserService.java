package com.demo.service;

public interface UserService {
    public boolean validate(String uname,String pass);

	public boolean addUser(String name, String lname, String email, String phone, String uname, String pass);
}
