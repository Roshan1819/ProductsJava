package com.demo.service;

import java.util.List;

import com.demo.beans.Products;

public interface ProductService {

	List<Products> getAll();

	boolean addProduct(Products p);

	boolean delete(int pid);

	Products getById(int id);

	boolean updateProduct(Products p);

}
