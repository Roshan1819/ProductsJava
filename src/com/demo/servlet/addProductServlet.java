package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Products;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

public class addProductServlet  extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		String name= request.getParameter("name");
		double price= Double.parseDouble(request.getParameter("price"));
		int qty= Integer.parseInt(request.getParameter("qty"));
		Products p= new Products(name,price,qty);
		ProductService pservice = new ProductServiceImpl();
		boolean status =pservice.addProduct(p);
		if(status) {
			RequestDispatcher rd= request.getRequestDispatcher("/product");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h3>Failed to Add Product </h3>");
			RequestDispatcher rd= request.getRequestDispatcher("/product");
			rd.include(request, response);
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request,response);
	}
	
}
