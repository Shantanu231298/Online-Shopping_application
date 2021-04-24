package com.cg.oss.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.oss.entities.Product;
import com.cg.oss.exception.OSSException;
import com.cg.oss.util.FactoryConnect;

public class ProductRepositoryImpl implements IProductRepository {
	public final FactoryConnect utill = new FactoryConnect();
	EntityManagerFactory emf = utill.getConnection();
	EntityManager em = emf.createEntityManager();
	EntityTransaction txn = em.getTransaction();
	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		txn.begin();
		list = em.createQuery("select a from Product a", Product.class).getResultList();
		txn.commit();
		return list;
	}

	@Override
	public Product addProduct(Product product) {
		
		txn.begin();
		em.persist(product);
		txn.commit();
		return product;

	}

	@Override
	public Product updateProduct(Product product) throws OSSException {
		txn.begin();
		if(product==null) {
			throw new OSSException("Invalid Input");
		}
		em.merge(product);
		txn.commit();
		return product;
	}

	@Override
	public Product viewProduct(int id) {
		txn.begin();
		Product product=em.find(Product.class,id);
		txn.commit();
		return product;
	}

	@Override
	public List<Product> viewProductsByCategory(String cat) {
		txn.begin();
		List<Product> list=new ArrayList<Product>();
		list=em.createQuery("select a from Product a where category=:'cat'",Product.class).setParameter("productCategory",cat).getResultList();
		txn.commit();
		return list;
	}

	@Override
	public Product removeProduct(String prodid) {
		
		Product product=em.find(Product.class,prodid);
		em.remove(product);
		return product;
	}

}
