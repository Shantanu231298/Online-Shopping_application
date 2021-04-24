package com.cg.oss.repository;

import java.util.ArrayList;
import java.util.List;
import com.cg.oss.entities.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.cg.oss.exception.OSSException;
import com.cg.oss.util.FactoryConnect;

public class CustomerRepositoryImpl implements ICustomerRepository {
	public final FactoryConnect util = new FactoryConnect();
	public final EntityManagerFactory emf = util.getConnection();
	public final EntityManager em = emf.createEntityManager();
	public final EntityTransaction txn = em.getTransaction();

	@Override
	public Customer addCustomer(Customer cust) throws OSSException {

		// EntityTransaction txn=em.getTransaction();
		txn.begin();
		em.persist(cust);
		txn.commit();
		return cust;
	}

	@Override
	public Customer updateCustomer(Customer cust) throws OSSException {
		// TODO Auto-generated method stub
		// EntityTransaction txn=em.getTransaction();
		txn.begin();
		em.merge(cust);
		txn.commit();
		return cust;
	}

	@Override
	public Customer removeCustomer(Customer cust) throws OSSException {
		// TODO Auto-generated method stub
		// EntityTransaction txn=em.getTransaction();
		Customer c = em.find(Customer.class, cust.getCustomerId());
		txn.begin();
		em.remove(c);
		txn.commit();
		return c;

	}

	@Override
	public Customer viewCustomer(Customer cust) throws OSSException {
		// TODO Auto-generated method stub
		txn.begin();
		Customer customerObject = em.find(Customer.class, cust.getCustomerId());
		txn.commit();
		return customerObject;
	}

	@Override
	public List<Customer> ViewAllCustomers(String location) throws OSSException {
		// TODO Auto-generated method stub
		List<Customer> list = new ArrayList<Customer>();
		list = em.createQuery("select c.address from Customer c", Customer.class).getResultList();
		return list;
	}

}
