package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Products;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/updateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("pid"));
		String nm= request.getParameter("name");
		double pr= Double.parseDouble(request.getParameter("price"));
		int qt= Integer.parseInt(request.getParameter("qty"));
		Products p= new Products(id,nm,pr,qt);
		System.out.println(p.getName()+"  "+p.getPid());
		ProductService pservice = new ProductServiceImpl();
		boolean status =pservice.updateProduct(p);
		
		if(status) {
			RequestDispatcher rd= request.getRequestDispatcher("/product");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h3>Failed to Update Product </h3>");
			RequestDispatcher rd= request.getRequestDispatcher("/product");
			rd.include(request, response);
		}
		
		
	}

}
