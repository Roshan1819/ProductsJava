package com.demo.service;

import java.util.List;

import com.demo.beans.Products;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService {
	
	private static ProductDao pdao;
	{
		pdao = new ProductDaoImpl();
	}
	@Override
	public List<Products> getAll() {
		List<Products> plist= pdao.getProducts();
		return plist;
	}
    
}
