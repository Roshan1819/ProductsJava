package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("HELO________________");
		
		PrintWriter out= response.getWriter();
		response.setContentType("text/html");
		int id= Integer.parseInt(request.getParameter("pid"));
		ProductService pservice = new ProductServiceImpl();
		boolean status=pservice.delete(id);
		if(status) {
			RequestDispatcher rd= request.getRequestDispatcher("/product");
			rd.forward(request, response);
		}
		else
		{
			out.println("<h3>Failed to Delete Product </h3>");
			RequestDispatcher rd= request.getRequestDispatcher("/product");
			rd.include(request, response);
		}
	}

}
