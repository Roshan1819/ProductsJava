package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Products;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		int id= Integer.parseInt(request.getParameter("pid"));
		System.out.println("ID :"+id);
		ProductService pservice = new ProductServiceImpl();
		 Products p = pservice.getById(id);
		
		
        out.println("<form action='updateProduct' method='post'> "
        +"<table>" +
        "<tr><td><label>ID</label></td><td><input type='text' value="+id+" name='pid' readonly></td></tr>"+
        "<tr><td><label>Name:</label></td><td><input type='text' value="+p.getName()+" name='name'></td></tr>"
        +"<tr><td><label>Quantity:</label></td><td><input type='number' value="+p.getQuantity()+" name='qty'></td></tr>");
        out.println("<tr><td><label>Price:</label></td><td><input type='number' value="+p.getPrice()+" name='price'></td></tr>");
        out.println("<tr><td></td><td><button type='submit' name='btn'>Update Product</button></td></tr>");
        out.println("</table>");
        out.println("</form>");


}
}	
