package com.demo.dao;

import java.sql.*;


import com.mysql.cj.jdbc.Driver;

public class DBTutil 
{

	static Connection con;

	public static Connection getConnection() {
		if(con == null) {
			try {
				String url = "jdbc:mysql://localhost:3306/Projects";

				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, "root", "123456");
				System.out.println("SQL Connection Done");

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return con;

	}

	public static void close() {
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
