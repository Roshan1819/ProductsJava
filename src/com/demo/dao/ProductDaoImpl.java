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
    private static PreparedStatement pgetProd,paddProd,pdelete;
    static {
    	   try{
    	    	  pgetProd= con.prepareStatement("select * from products");
    	          paddProd= con.prepareStatement("insert into products(ProductName,price,quantity) values(?,?,?)");
                  pdelete= con.prepareStatement("delete from products where ProductName=?");
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
            plist.add(new Products(rs.getString(2), rs.getDouble(3), rs.getInt(4)));
            
		}
		System.out.println(plist);
				return plist;
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
	}  
}
