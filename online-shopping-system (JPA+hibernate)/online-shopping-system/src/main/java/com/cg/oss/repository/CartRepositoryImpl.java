package com.cg.oss.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.oss.entities.Cart;
import com.cg.oss.entities.Order;
import com.cg.oss.entities.Product;
import com.cg.oss.util.FactoryConnect;

public class CartRepositoryImpl implements ICartRepository {
	public final FactoryConnect util = new FactoryConnect();
	public final EntityManagerFactory emf = util.getConnection();
	public final EntityManager em = emf.createEntityManager();
	EntityTransaction txn = em.getTransaction();

	@Override
	public Cart addProductToCart(Cart cart, Product p, int quantity) {
		txn.begin();
		em.persist(cart);
		em.persist(p);
		em.persist(quantity);
		txn.commit();
		return cart;
	}

	@Override
	public Cart removeProductFromCart(Cart cart, Product p) {
		Cart cart1 = em.find(Cart.class, p);
		em.remove(cart1);
		return cart1;
	}

	@Override
	public Cart updateProductQuantity(Cart cart, Product p, int quantity) {
		Cart cart1 = em.find(Cart.class, p);
		em.merge(cart1);
		em.merge(p);
		em.merge(quantity);
		return cart1;
	}

	@Override
	public Cart removeAllProducts(Cart cart) {
		em.remove(cart);
		return cart;
	}

	@Override
	public List<Product> viewAllProducts(Cart cart) {
		List<Product> list = new ArrayList<Product>();
		list = em.createQuery("select c from Cart c", Product.class).getResultList();
		return list;
	}

}
