package com.cg.oss.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.oss.entities.Customer;
import com.cg.oss.entities.Order;
import com.cg.oss.entities.Product;
import com.cg.oss.exception.OSSException;
import com.cg.oss.util.FactoryConnect;

public class OrderRepositoryImpl implements IOrderRepository {
	private static EntityManagerFactory emf = new FactoryConnect().getConnection();
	private static EntityManager em = emf.createEntityManager();
	private static EntityTransaction txn = em.getTransaction();

	@Override
	public Order addOrder(Order order) throws OSSException {
		// TODO Auto-generated method stub
		txn.begin();
		order = em.merge(order);
		if (order == null) {
			throw new OSSException("OrderEntity not found");
		} else {
			em.persist(order);
			return order;
		}
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		String query = "UPDATE order_pr o set o.userId=:userid,o.addressId=:addressid,o.orderStatus=:orderstatus,o.orderDate=:orderdate where orderId=:Id";
		TypedQuery<Product> a = em.createQuery(query, Product.class);
		a.setParameter(0, order.getUserId());
		a.setParameter(1, order.getAddressId());
		a.setParameter(2, order.getOrderStatus());
		a.setParameter(3, order.getOrderDate());
		a.executeUpdate();
		return null;

	}

	@Override
	public Order removeOrder(Order order) {
		// TODO Auto-generated method stub
		txn.begin();
		em.remove(order);
		txn.commit();
		return order;
	}

	@Override
	public Order viewOrder(String order_id) {
		// TODO Auto-generated method stub
		Order order = em.find(Order.class, order_id);
		return order;
	}

	@Override
	public List<Order> viewAllOrders(LocalDate date) {
		List<Order> list = new ArrayList<Order>();
		list = em.createQuery("from Order where date=:orderdate", Order.class).setParameter("Date", "orderdate")
				.getResultList();
		return list;
	}

	@Override
	public List<Order> viewAllOrdersByLocation(String location) {
		List<Order> list = new ArrayList<Order>();
		list = em.createQuery("select c.address from Customer c", Order.class).getResultList();
		return list;
	}

	@Override
	public List<Order> viewAllOrderByUserId(String userid) {
		List<Order> list = new ArrayList<Order>();
		list = em.createQuery("select c.userid from Order c", Order.class).getResultList();
		return list;
	}

}
