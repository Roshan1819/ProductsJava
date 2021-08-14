package com.demo.dao;

import java.util.List;

import com.demo.beans.Products;

public interface ProductDao {

	List<Products> getProducts();

	boolean add(Products p);

	boolean delete(int pid);

	Products getById(int id);

	boolean update(Products p);


}
