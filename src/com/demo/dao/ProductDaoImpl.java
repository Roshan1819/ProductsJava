package com.demo.dao;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Products;
public class ProductDaoImpl implements ProductDao{

    static Connection con = DBTutil.getConnection();
    private static PreparedStatement pgetProd,paddProd,pdelete,pgetById,pupdate;
    static {
    	   try{
    	    	  pgetProd= con.prepareStatement("select * from products");
    	          paddProd= con.prepareStatement("insert into products(ProductName,price,quantity) values(?,?,?)");
                  pdelete= con.prepareStatement("delete from products where pid=?");
				  pgetById= con.prepareStatement("select * from products where pid=?");
				  pupdate= con.prepareStatement("update products set Productname=? , price=? , quantity=? where pid=?");
			}catch(SQLException e) {
    	    	e.printStackTrace();
    	    }
    	    
    }
	@Override
	public List<Products> getProducts() {
		List<Products> plist = new ArrayList<>();
        try{
		ResultSet rs = pgetProd.executeQuery();
		while(rs.next()){
            plist.add(new Products(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getInt(4)));
            
		}
		System.out.println(plist);
				return plist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
	}
	@Override
	public boolean add(Products p) {
		try {
			paddProd.setString(1, p.getName());
			paddProd.setDouble(2, p.getPrice());
			paddProd.setInt(3, p.getQuantity());
			int n=paddProd.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean delete(int pid) {
		try {
			pdelete.setInt(1,pid);
			int n=pdelete.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	@Override
	public Products getById(int id) {
		Products p = null;
		try {
			pgetById.setInt(1, id);
			ResultSet rs= pgetById.executeQuery();
			if(rs.next()){
			p= new Products(rs.getInt(1),rs.getString(2), rs.getDouble(3), rs.getInt(4));
			System.out.println(p.getName() + " from dao");
			return p;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}
	@Override
	public boolean update(Products p) {
		try {
			pupdate.setString(1, p.getName());
			pupdate.setDouble(2, p.getPrice());
			pupdate.setInt(3, p.getQuantity());
			pupdate.setInt(4, p.getPid());
			int n = pupdate.executeUpdate();
			if(n > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}  
}
