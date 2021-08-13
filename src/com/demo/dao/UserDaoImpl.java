package com.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.User;
import java.sql.Connection;

public class UserDaoImpl implements UserDao{

    static Connection con = DBTutil.getConnection();
    private static PreparedStatement pgetUser,paddUser;
    static {
    	   try{
    	    	  pgetUser= con.prepareStatement("select * from users where username=? and password=?");
    	          paddUser= con.prepareStatement("insert into users(Firstname, Lastname, Email, Contact, Username, Password) values(?,?,?,?,?,?)");
            }catch(SQLException e) {
    	    	e.printStackTrace();
    	    }
    	    
    }
 


      public User validate(String uname,String pass){
        User u= null;
        
        try {
        	pgetUser.setString(1,uname);
			pgetUser.setString(2,pass);
			   ResultSet rs= pgetUser.executeQuery();
		        if(rs.next()){
		            u= new User(rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));   
		        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
        return u;
      }



	@Override
	public boolean addUser(User u) {
		try {
			paddUser.setString(1, u.getFirstname());
            paddUser.setString(2, u.getLastname());
            paddUser.setString(3, u.getEmail());
            paddUser.setString(4, u.getPhone());
            paddUser.setString(5, u.getUname());
            paddUser.setString(6, u.getPass());

            int n= paddUser.executeUpdate();
            if(n>0){
                return true;
            }
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
