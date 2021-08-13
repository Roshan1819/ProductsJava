package com.demo.servlet;
import com.demo.service.*;
import java.io.PrintWriter;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Validate extends HttpServlet{
    public void doPost(HttpServletRequest request ,HttpServletResponse response) throws IOException, ServletException{
    PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    UserService userService = new UserServiceImpl();
    String uname= request.getParameter("uname");
    String pass= request.getParameter("pass");
    
    boolean status = userService.validate(uname,pass);
    if(status){
        out.println("<center><font style=\"color: green;\">Login Successful</font></center>");
        RequestDispatcher re = request.getRequestDispatcher("/product");
        re.include(request, response);
    }else{
        out.println("<center><font style=\"color: red;\">Invalid Credentials. Try Again !</font></center>");
        RequestDispatcher re = request.getRequestDispatcher("/login.html");
        re.include(request, response);
    }
    
    }
}
