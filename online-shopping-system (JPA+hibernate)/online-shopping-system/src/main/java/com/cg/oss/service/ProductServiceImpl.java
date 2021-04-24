package com.cg.oss.service;

import java.util.List;

import com.cg.oss.entities.Product;
import com.cg.oss.exception.OSSException;
import com.cg.oss.repository.IProductRepository;
import com.cg.oss.repository.ProductRepositoryImpl;

public class ProductServiceImpl implements IProductService {
	private static IProductRepository prod = new ProductRepositoryImpl();

	@Override
	public List<Product> viewAllProducts() throws OSSException {
		// TODO Auto-generated method stub
		List<Product> tList = prod.viewAllProducts();
		return tList;
	}

	@Override
	public Product addProduct(Product product) throws OSSException {
		if (product != null)
			return prod.addProduct(product);
		else
			throw new OSSException("no product details found");

	}

	@Override
	public Product updateProduct(Product product) throws OSSException {
		// TODO Auto-generated method stub
		if (product != null)
			return prod.updateProduct(product);
		else
			throw new OSSException("product detail nt found");

	}

	@Override
	public Product viewProduct(int id) throws OSSException {
		// TODO Auto-generated method stub
		Product pr = prod.viewProduct(id);
		return pr;
	}

	@Override
	public List<Product> viewProductsByCategory(String cat) throws OSSException {
		// TODO Auto-generated method stub
		List<Product> t = prod.viewAllProducts();
		return t;
	}

	@Override
	public Product removeProduct(String prodid) throws OSSException {
		// TODO Auto-generated method stub
		return prod.removeProduct(prodid);

	}

}
