package com.cg.oss.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.oss.entities.Order;
import com.cg.oss.exception.OSSException;
import com.cg.oss.repository.IOrderRepository;
import com.cg.oss.repository.OrderRepositoryImpl;

public class OrderServiceImpl implements IOrderService{
	
	private static IOrderRepository ord =new OrderRepositoryImpl();
	
	@Override
	public Order addOrder(Order order) throws OSSException {
		// TODO Auto-generated method stub
		if(order!=null) 
			 return ord.addOrder(order);
		 else throw new OSSException("no order details found");
		

	}

	@Override
	public Order updateOrder(Order order) throws OSSException {
		// TODO Auto-generated method stub
		if(order!=null)
			return ord.updateOrder(order);
		else 
			throw new OSSException("order detail nt found");
		
	}

	@Override
	public Order removeOrder(Order order) throws OSSException {
		// TODO Auto-generated method stub
		return ord.removeOrder(order);
	}

	@Override
	public Order viewOrder(String order_id) throws OSSException {
		// TODO Auto-generated method stub
		Order o= ord.viewOrder(order_id);
		return o;
	}

	@Override
	public List<Order> viewAllOrders(LocalDate date) throws OSSException {
		// TODO Auto-generated method stub
		List<Order> t=ord.viewAllOrders(date);
		return t;
	}

	@Override
	public List<Order> viewAllOrdersByLocation(String location) throws OSSException {
		// TODO Auto-generated method stub
		List<Order> t=ord.viewAllOrdersByLocation(location);
		return t;
	}

	@Override
	public List<Order> viewAllOrderByUserId(String userid) throws OSSException {
		// TODO Auto-generated method stub
		List<Order> t=ord.viewAllOrderByUserId(userid);
		return t;
	}

}
