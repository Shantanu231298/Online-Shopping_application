package com.cg.oss.service;

import java.util.List;

import com.cg.oss.entities.Product;
import com.cg.oss.exception.OSSException;

public interface IProductService {
	public List<Product> viewAllProducts() throws OSSException;

	public Product addProduct(Product product) throws OSSException;

	public Product updateProduct(Product product) throws OSSException;

	public Product viewProduct(int id) throws OSSException;

	public List<Product> viewProductsByCategory(String cat) throws OSSException;

	public Product removeProduct(String prodid) throws OSSException;
}
