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
	@Override
	public boolean addProduct(Products p) {
		boolean flag= pdao.add(p);
		return flag;
	}
	@Override
	public boolean delete(int pid) {
		boolean flag= pdao.delete(pid);
		return flag;
	}
	@Override
	public Products getById(int id) {
		System.out.println("In service-------"+id);
		Products p= pdao.getById(id);
		return p;
	}
	@Override
	public boolean updateProduct(Products p) {
		boolean flag= pdao.update(p);
		return flag;
	}
    
}
