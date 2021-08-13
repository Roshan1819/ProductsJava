package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.http.*;

import com.demo.beans.User;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;


public class RegUser extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		UserService userService = new UserServiceImpl();
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		String name = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phn");
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		System.out.println("First Name : "+name);
		System.out.println("Last Name : "+lname);
		System.out.println("Email Id : "+email);
		System.out.println("Phone Number : "+phone);
		System.out.println("User Name : "+uname);
		
		boolean status = userService.addUser(name,lname,email,phone,uname,pass);
		if(status){
			System.out.println("Inserted");
		}else
		{
			System.out.println("Failed");
		}
		
		 
	}
		
}
