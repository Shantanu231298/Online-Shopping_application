package com.cg.oss.entities;

import java.util.HashMap;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@Column(name = "cartid")
	private String cartId;
	@Column(name = "userid")
	private String userId;
	// private HashMap<Product, Integer> products;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "productId")
	private Product product;
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "customerid")
	private Customer customer;

	Cart() {
	}

	public Cart(String cartId, String userId, Product product, Customer customer) {
		super();
		this.cartId = cartId;
		this.userId = userId;
		// this.products = products;
		this.product = product;
		this.customer = customer;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/*
	 * public HashMap<Product, Integer> getProducts() { return products; }
	 */

	/*
	 * public void setProducts(HashMap<Product, Integer> products) { this.products =
	 * products; }
	 */

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", userId=" + userId + ", product=" + product + ", customer=" + customer
				+ "]";
	}

}
