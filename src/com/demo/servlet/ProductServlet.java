package com.demo.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import com.demo.beans.Products;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
public class ProductServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ProductService pservice = new ProductServiceImpl();
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		List<Products> plist = new ArrayList<>();

		plist = pservice.getAll();
		//		System.out.println(plist);
		if(plist != null) {
			out.print("<center><h1>Product Table</h1></center>");
			out.println("<center><table border = '2px solid-black'>");
			out.println("<tr><th>Pruduct Id</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th><th>Action</th></tr>");
			for(Products p : plist){
				out.println("<tr>");
				out.println("<td>"+p.getPid()+"</td><td>"+p.getName()+"</td><td>"+p.getPrice()+"</td><td>"+p.getQuantity()+"</td>");
				out.println("<td><a href='edit?pid="+p.getPid()+"'>Edit</a>| <a href='delete?pid="+p.getPid()+"'>Delete</a></td>");
				out.println("</tr>");
			}
			out.println("</table></center>");
			out.println("<center><button><a href='addProduct.html'>ADD PRODUCT</a></button></center>");
		}		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doPost(request,response);
	}
}
