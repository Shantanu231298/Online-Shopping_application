package com.cg.oss.service;

import java.util.List;

import com.cg.oss.entities.Cart;
import com.cg.oss.entities.Product;
import com.cg.oss.repository.ICartRepository;

public class CartServiceImpl implements ICartService {
	private ICartRepository daoCartRepo;

	@Override
	public Cart addProductToCart(Cart cart, Product p, int quantity) {
		// TODO Auto-generated method stub
		return daoCartRepo.addProductToCart(cart, p, quantity);
	}

	@Override
	public Cart removeProductFromCart(Cart cart, Product p) {
		// TODO Auto-generated method stub
		return removeProductFromCart(cart, p);
	}

	@Override
	public Cart updateProductQuantity(Cart cart, Product p, int quantity) {
		// TODO Auto-generated method stub
		return updateProductQuantity(cart, p, quantity);
	}

	@Override
	public Cart removeAllProducts(Cart cart) {
		// TODO Auto-generated method stub
		return removeAllProducts(cart);
	}

	@Override
	public List<Product> viewAllProducts(Cart cart) {
		// TODO Auto-generated method stub
		return daoCartRepo.viewAllProducts(cart);
	}

}
