package com.cg.oss.repository;

import java.time.LocalDate;
import java.util.List;

import com.cg.oss.entities.Order;
import com.cg.oss.exception.OSSException;

public interface IOrderRepository {
	public Order addOrder(Order order) throws OSSException;

	public Order updateOrder(Order order) throws OSSException;

	public Order removeOrder(Order order) throws OSSException;

	public Order viewOrder(String order_id) throws OSSException;

	public List<Order> viewAllOrders(LocalDate date) throws OSSException;

	public List<Order> viewAllOrdersByLocation(String location) throws OSSException;

	public List<Order> viewAllOrderByUserId(String userid) throws OSSException;
}
