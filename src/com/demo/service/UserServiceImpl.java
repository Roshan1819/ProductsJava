package com.demo.service;

import com.demo.beans.User;
import com.demo.dao.UserDao;
import com.demo.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(){
       this.userDao= new UserDaoImpl();
    }
    public boolean validate(String uname,String pass){
        User u = userDao.validate(uname,pass);
        if(u!=null){
            if((u.getUname().equals(uname)) && (u.getPass().equals(pass))){
                return true;
            }
        }
        return false;
    }
	@Override
	public boolean addUser(String name, String lname, String email, String phone, String uname, String pass) {
		User u = new User(name,lname,email,phone,uname,pass);
        if(u != null)
        	return userDao.addUser(u);
		return false;
	}
}
