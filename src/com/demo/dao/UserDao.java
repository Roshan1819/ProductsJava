package com.demo.dao;

import com.demo.beans.User;

public interface UserDao  {
     User validate(String uname,String pass);

	boolean addUser(User u);
}
